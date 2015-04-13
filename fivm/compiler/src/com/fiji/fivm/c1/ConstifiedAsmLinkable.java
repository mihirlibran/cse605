/*
 * ConstifiedAsmLinkable.java
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

import java.io.*;

public class ConstifiedAsmLinkable extends Linkable {
    String section;
    String asm;
    
    LinkableSet subset;
    
    boolean isLocal;
    
    public ConstifiedAsmLinkable(Linkable l,
                                 LinkableSet set) {
        super(l.getType(),l.getName());
        
        isLocal=l.isLocal();
        
        section=l.asmSection();
        
        StringWriter sw=new StringWriter();
        PrintWriter pw=new PrintWriter(sw);
        l.generateAsm(pw);
        pw.flush();
        asm=sw.toString();
        
        subset=constify(l.subLinkables(),set);
    }
    
    public boolean isLocal() {
        return isLocal;
    }
    
    public void generateDeclaration(PrintWriter w) {
        throw new CompilerException("Cannot generate C code for "+this);
    }
    
    public void generateDefinition(PrintWriter w) {
        throw new CompilerException("Cannot generate C code for "+this);
    }
    
    public String asmSection() {
        return section;
    }
    
    public void generateAsm(PrintWriter w) {
        w.print(asm);
    }
    
    public LinkableSet subLinkables() {
        return subset;
    }
    
    public static ConstifiedAsmLinkable constify(Linkable l,
                                                 LinkableSet s) {
        ConstifiedAsmLinkable result=(ConstifiedAsmLinkable)s.get(l.getName());
        if (result==null) {
            result=new ConstifiedAsmLinkable(l,s);
            s.add(result);
        }
        return result;
    }
    
    public static LinkableSet constify(LinkableSet in,
                                       LinkableSet out) {
        for (Linkable l : in) {
            constify(l,out);
        }
        return out;
    }
    
    public static LinkableSet constify(LinkableSet in) {
        LinkableSet out=new LinkableSet();
        return constify(in,out);
    }
}

