/*
 * Switch.java
 * Copyright 2008, 2009, 2010, 2011, 2012, 2013 Fiji Systems Inc.
 * This file is part of the FIJI VM Software licensed under the FIJI PUBLIC
 * LICENSE Version 3 or any later version.  A copy of the FIJI PUBLIC LICENSE is
 * available at fivm/LEGAL and can also be found at
 * http://www.fiji-systems.com/FPL3.txt
 * 
 * By installing, reproducing, distributing, and/or using the FIJI VM Software
 * you agree to the terms of the FIJI PUBLIC LICENSE.  You may exercise the
 * rights granted under the FIJI PUBLIC LICENSE subject to the conditions and
 * restrictions stated therein.  Among other conditions and restrictions, the
 * FIJI PUBLIC LICENSE states that:
 * 
 * a. You may only make non-commercial use of the FIJI VM Software.
 * 
 * b. Any adaptation you make must be licensed under the same terms 
 * of the FIJI PUBLIC LICENSE.
 * 
 * c. You must include a copy of the FIJI PUBLIC LICENSE in every copy of any
 * file, adaptation or output code that you distribute and cause the output code
 * to provide a notice of the FIJI PUBLIC LICENSE. 
 * 
 * d. You must not impose any additional conditions.
 * 
 * e. You must not assert or imply any connection, sponsorship or endorsement by
 * the author of the FIJI VM Software
 * 
 * f. You must take no derogatory action in relation to the FIJI VM Software
 * which would be prejudicial to the FIJI VM Software author's honor or
 * reputation.
 * 
 * 
 * The FIJI VM Software is provided as-is.  FIJI SYSTEMS INC does not make any
 * representation and provides no warranty of any kind concerning the software.
 * 
 * The FIJI PUBLIC LICENSE and any rights granted therein terminate
 * automatically upon any breach by you of the terms of the FIJI PUBLIC LICENSE.
 */

package com.fiji.fivm.c1;

import java.util.*;
import java.nio.*;

public final class Switch extends Control {
    
    Header[] targets;
    int[] values;
    
    public Switch(DebugInfo di,
		  Arg[] rhs,
		  Header next,
		  Header[] targets,
		  int[] values) {
	super(di,OpCode.Switch,rhs,next);
	this.targets=targets;
	this.values=values;
	assert targets.length==values.length;
    }
    
    public int numCases() { return targets.length; }
    public Header[] targets() { return targets; }
    public Header target(int i) { return targets[i]; }
    public int[] values() { return values; }
    public int value(int i) { return values[i]; }
    
    public Header targetFor(int value) {
	for (int i=0;i<numCases();++i) {
	    if (values[i]==value) {
		return targets[i];
	    }
	}
	return (Header)next;
    }
    
    public Iterable< Header > successors() {
	return new Iterable< Header >() {
	    public Iterator< Header > iterator() {
		return new Iterator< Header >() {
		    int i=-1;
		    public Header next() {
			Header result;
			if (i==-1) {
			    result=(Header)next;
			} else {
			    try {
				result=targets[i];
			    } catch (ArrayIndexOutOfBoundsException e) {
				throw new NoSuchElementException();
			    }
			}
			i++;
			return result;
		    }
		    public boolean hasNext() {
			return i<targets.length;
		    }
		    public void remove() {
			throw new UnsupportedOperationException();
		    }
		};
	    }
	};
    }
    
    public Switch copy() {
	Switch result=(Switch)super.copy();
	result.targets=new Header[targets.length];
	result.values=new int[values.length];
	System.arraycopy(targets,0,
			 result.targets,0,
			 targets.length);
	System.arraycopy(values,0,
			 result.values,0,
			 values.length);
	return result;
    }
    
    public <T> T accept(Visitor<T> v) {
	return v.visit(this);
    }
    
    int getNioSize() {
        return super.getNioSize()+4+4+targets.length*(4+4);
    }
    
    void writeTo(NioContext ctx,
                 ByteBuffer buffer) {
        super.writeTo(ctx,buffer);
        buffer.putInt(ctx.nodeCodes.codeFor(next));
        buffer.putInt(numCases());
        for (int i=0;i<numCases();++i) {
            buffer.putInt(ctx.nodeCodes.codeFor(targets[i]));
            buffer.putInt(values[i]);
        }
    }
}


