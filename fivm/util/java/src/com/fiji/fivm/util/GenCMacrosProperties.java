/*
 * GenCMacrosProperties.java
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

package com.fiji.fivm.util;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

import java.util.HashSet;
import java.util.Set;

import com.fiji.asm.ClassReader;
import com.fiji.asm.UTF8Sequence;
import com.fiji.asm.commons.EmptyVisitor;
import com.fiji.asm.AnnotationVisitor;
import com.fiji.asm.MethodVisitor;

import com.fiji.fivm.c1.ClassFileIterator;
import com.fiji.fivm.c1.Global;

public class GenCMacrosProperties extends EmptyVisitor {
    private Set<String> defines;

    public GenCMacrosProperties(Set<String> defines) {
	this.defines = defines;
    }

    public void visit(int version, int access, UTF8Sequence name,
		      UTF8Sequence signature, UTF8Sequence superName,
		      UTF8Sequence[] interfaces) {
    }

    public void visit(UTF8Sequence name, Object value) {
        if (value instanceof String) {
            defines.add((String)value);
        }
    }

    public MethodVisitor visitMethod(int access, UTF8Sequence name, UTF8Sequence desc,
                                     UTF8Sequence sig, UTF8Sequence[] exceptions) {
	return this;
    }

    public AnnotationVisitor visitAnnotation(UTF8Sequence sig, boolean visible) {
	if (sig.toString().equals("Lcom/fiji/fivm/r1/IfPoundDefined;")) {
	    return this;
	}
	return null;
    }

    public static void main(String[] args)
	throws FileNotFoundException, IOException {
	final HashSet<String> defines = new HashSet<String>();
	final GenCMacrosProperties gcmp = new GenCMacrosProperties(defines);

	if (args.length != 1) {
	    System.err.println("GenCMacrosProperties requires one argument: configuration");
	    System.exit(-1);
	}
	Global.verbosity = 0;
	ClassFileIterator cfi = new ClassFileIterator() {
		public void addClass(final String classname, byte[] bytecode) {
		    ClassReader cr = new ClassReader(bytecode);
		    cr.accept(gcmp, ClassReader.SKIP_FRAMES|ClassReader.SKIP_DEBUG);
		    for (int i = 0; ; i++) {
			try {
			    cr.getItem(i);
			} catch (ArrayIndexOutOfBoundsException e) {
			    break;
			}
			try {
			    Object o = cr.readConst(i);
			    if (o instanceof String) {
				String s = (String)o;
				if (s.matches("^[A-Za-z_][A-Za-z0-9_]*$")) {
				    defines.add(s);
				}
			    }
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		    }
		}
	    };
	BufferedReader br =
	    new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
	for (String flnm = br.readLine(); flnm != null; flnm = br.readLine()) {
	    if (flnm.equals("")) {
		continue;
	    }
	    cfi.addClassOrJar(flnm);
	}

	/* Remove illegal things from the set */
	defines.remove("defined");
    
	PrintWriter out = new PrintWriter(System.out);
	out.println("/* generated by GenCMacrosProperties.java */");
	out.println("/* DO NOT EDIT! */");
	out.println("#include <fivmr_target.h>");
	try {
	    for (String define : defines) {
		out.println("#ifdef " + define);
		out.println("#undef " + define);
		out.println(define + " = yes");
		out.println("#endif");
	    }
	} finally {
	    out.close();
	}
    }
}
