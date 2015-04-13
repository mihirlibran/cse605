/* VMPlainSocketImpl.java -- VM interface for default socket implementation
   Copyright (C) 2005, 2006 Free Software Foundation, Inc.

This file is part of GNU Classpath.

GNU Classpath is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2, or (at your option)
any later version.
 
GNU Classpath is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with GNU Classpath; see the file COPYING.  If not, write to the
Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
02110-1301 USA.

Linking this library statically or dynamically with other modules is
making a combined work based on this library.  Thus, the terms and
conditions of the GNU General Public License cover the whole
combination.

As a special exception, the copyright holders of this library give you
permission to link this library with independent modules to produce an
executable, regardless of the license terms of these independent
modules, and to copy and distribute the resulting executable under
terms of your choice, provided that you also meet, for each linked
independent module, the terms and conditions of the license of that
module.  An independent module is a module which is not derived from
or based on this library.  If you modify this library, you may extend
this exception to your version of the library, but you are not
obligated to do so.  If you do not wish to do so, delete this
exception statement from your version. */

package gnu.java.net;

import gnu.java.nio.FCChannel;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.SocketOptions;

/**
 * The VM interface for {@link gnu.java.net.PlainSocketImpl}.
 *
 * @author Ingo Proetel (proetel@aicas.com)
 * @author Roman Kennke (kennke@aicas.com)
 */
public final class FCPlainSocketImpl
{
  /** Option id for time to live
   */
  private static final int CP_IP_TTL = 0x1E61;

  private final State nfd;
  
  public FCPlainSocketImpl()
  {
    // XXX consider adding security check here.
    nfd = new State();
  }
  
  public FCPlainSocketImpl(FCChannel channel) throws IOException
  {
    this();
    nfd.setChannelFD(channel.getState());
  }
  
  public State getState()
  {
    return nfd;
  }

  /** This method exists to hide the CP_IP_TTL value from
   * higher levels.
   *
   * Always think of JNode ... :)
   */
  public void setTimeToLive(int ttl)
    throws SocketException
  {
    try
      {
        FCNativePlainSocketImpl.setOption(nfd.getNativeFD(), CP_IP_TTL, ttl);
      }
    catch (IOException ioe)
      {
        SocketException se = new SocketException();
        se.initCause(ioe);
        throw se;
      }
  }

  public int getTimeToLive()
    throws SocketException
  {
    try
      {
        return FCNativePlainSocketImpl.getOption(nfd.getNativeFD(), CP_IP_TTL);
      }
    catch (IOException ioe)
      {
        SocketException se = new SocketException();
        se.initCause(ioe);
        throw se;
      }
  }

  public void setOption(int optionId, Object optionValue)
    throws SocketException
  {
    int value;
    if (optionValue instanceof Integer)
      value = ((Integer) optionValue).intValue();
    else if (optionValue instanceof Boolean)
      // Switching off the linger behavior is done by setting
      // the value to -1. This is how the Java API interprets
      // it.
      value = ((Boolean) optionValue).booleanValue()
              ? 1
              : (optionId == SocketOptions.SO_LINGER)
              ? -1
              : 0;
    else
      throw new IllegalArgumentException("option value type "
                                         + optionValue.getClass().getName());
    
    try
      {
        FCNativePlainSocketImpl.setOption(nfd.getNativeFD(), optionId, value);
      }
    catch (IOException ioe)
      {
        SocketException se = new SocketException();
        se.initCause(ioe);
        throw se;
      }
  }
  
  /**
   * Get a socket option. This implementation is only required to support
   * socket options that are boolean values, which include:
   * 
   *  SocketOptions.IP_MULTICAST_LOOP
   *  SocketOptions.SO_BROADCAST
   *  SocketOptions.SO_KEEPALIVE
   *  SocketOptions.SO_OOBINLINE
   *  SocketOptions.SO_REUSEADDR
   *  SocketOptions.TCP_NODELAY
   * 
   * and socket options that are integer values, which include:
   * 
   *  SocketOptions.IP_TOS
   *  SocketOptions.SO_LINGER
   *  SocketOptions.SO_RCVBUF
   *  SocketOptions.SO_SNDBUF
   *  SocketOptions.SO_TIMEOUT
   *
   * @param optionId The option ID to fetch.
   * @return A {@link Boolean} or {@link Integer} containing the socket
   *  option.
   * @throws SocketException
   */
  public Object getOption(int optionId) throws SocketException
  {
    int value;
    try
      {
        value = FCNativePlainSocketImpl.getOption(nfd.getNativeFD(), optionId);
      }
    catch (IOException ioe)
      {
        SocketException se = new SocketException();
        se.initCause(ioe);
        throw se;
      }
    
    switch (optionId)
      {
        case SocketOptions.SO_BROADCAST:
        case SocketOptions.SO_KEEPALIVE:
        case SocketOptions.SO_OOBINLINE:
        case SocketOptions.SO_REUSEADDR:
        case SocketOptions.TCP_NODELAY:
          return Boolean.valueOf(value != 0);
          
        case SocketOptions.IP_TOS:
        case SocketOptions.SO_LINGER:
        case SocketOptions.SO_RCVBUF:
        case SocketOptions.SO_SNDBUF:
        case SocketOptions.SO_TIMEOUT:
          return new Integer(value);
          
        default:
          throw new SocketException("getting option " + optionId +
                                    " not supported here");
      }
  }
  
  /**
   * Binds this socket to the given local address and port.
   *
   * @param address The address to bind to; the InetAddress is either
   *  an IPv4 or IPv6 address.
   * @throws IOException If binding fails; for example, if the port
   *  in the given InetSocketAddress is privileged, and the current
   *  process has insufficient privileges.
   */
  public void bind(InetSocketAddress address) throws IOException
  {
    InetAddress addr = address.getAddress();
    if (addr instanceof Inet4Address)
      {
        FCNativePlainSocketImpl.bind (nfd.getNativeFD(), addr.getAddress(), address.getPort());
      }
    else if (addr instanceof Inet6Address)
      FCNativePlainSocketImpl.bind6 (nfd.getNativeFD(), addr.getAddress(), address.getPort());
    else
      throw new SocketException ("unsupported address type");
  }
  
  /**
   * Listen on this socket for incoming connections.
   *
   * @param backlog The backlog of connections.
   * @throws IOException If listening fails.
   * @see gnu.java.nio.FCChannel#accept()
   */
  public void listen(int backlog) throws IOException
  {
    FCNativePlainSocketImpl.listen(nfd.getNativeFD(), backlog);
  }
  
  public void shutdownInput() throws IOException
  {
    FCNativePlainSocketImpl.shutdownInput(nfd.getNativeFD());
  }
  
  public void shutdownOutput() throws IOException
  {
    FCNativePlainSocketImpl.shutdownOutput(nfd.getNativeFD());
  }
  
  public void sendUrgentData(int data) throws IOException
  {
    FCNativePlainSocketImpl.sendUrgentData(nfd.getNativeFD(), data);
  }
  
  public void close() throws IOException
  {
    nfd.close();
  }
  
  // Inner classes.
  
  /**
   * Our wrapper for the native file descriptor. In this implementation,
   * it is a simple wrapper around {@link FCChannel.State}, to simplify
   * management of the native state.
   */
  public final class State
  {
    private FCChannel.State channelFd;
    
    State()
    {
      channelFd = null;
    }
    
    public boolean isValid()
    {
      if (channelFd != null)
        return channelFd.isValid();
      return false;
    }
    
    public int getNativeFD() throws IOException
    {
      return channelFd.getNativeFD();
    }
    
    public void setChannelFD(final FCChannel.State nfd) throws IOException
    {
      if (this.channelFd != null && this.channelFd.isValid())
        throw new IOException("file descriptor already initialized");
      this.channelFd = nfd;
    }
    
    public void close() throws IOException
    {
      if (channelFd == null)
        throw new IOException("invalid file descriptor");
      channelFd.close();
    }
    
    protected void finalize() throws Throwable
    {
      try
        {
          if (isValid())
            close();
        }
      finally
        {
          super.finalize();
        }
    }
  }
}

