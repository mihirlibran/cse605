/*
 * PoundDefineExtractor.java
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

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class PoundDefineExtractor extends Code.Visitor {
    HashSet< String > poundDefines=new HashSet< String >();
    
    @SuppressWarnings("unchecked")
    public void visit(Code code) {
	VisibleAnnotation va=code.origin().origin().getAnnotation(Runtime.ifPoundDefined);
	if (va!=null) {
	    poundDefines.addAll((List< String >)va.get("value"));
	}
	for (Header h : code.headers()) {
	    for (Instruction i : h.instructions()) {
		if (i.opcode()==OpCode.PoundDefined) {
		    poundDefines.add(((CMacroInst)i).cmacro());
		}
	    }
	}
    }
    
    public Set< String > poundDefines() { return poundDefines; }
    
    public void generateCode(String filename) throws IOException {
	PrintWriter fout=Util.wrap(new FileOutputStream(filename));
	try {
	    fout.println("/* generated by PoundDefineExtractor.java */");
	    fout.println("/* DO NOT EDIT! */");
	    fout.println("#include <fivmr_target.h>");
	    for (String cmacro : poundDefines()) {
		fout.println("#ifdef "+cmacro);
		fout.println("#undef "+cmacro);
		fout.println(cmacro+" = true");
		fout.println("#else");
		fout.println(cmacro+" = false");
		fout.println("#endif");
	    }
	} finally {
	    fout.close();
	}
    }
}
