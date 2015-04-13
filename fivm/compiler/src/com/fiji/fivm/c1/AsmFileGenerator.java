/*
 * AsmFileGenerator.java
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
import java.io.*;

public class AsmFileGenerator {
    String name;
    LinkableSet code;
    
    public AsmFileGenerator(String name,
                            LinkableSet code) {
	this.name=name;
	this.code=code;
    }
    
    public AsmFileGenerator(String name,
                            Linkable l) {
	this.name=name;
	this.code=l.linkables();
    }
    
    public void generate(String filename) throws IOException {
	if (!code.isEmpty()) {
	    PrintWriter fout=Util.wrap(new FileOutputStream(filename));
	    try {
		generate(filename,fout);
	    } finally {
		fout.close();
	    }
	}
    }
    
    public void generate(String filename,PrintWriter w) {
        long before=System.currentTimeMillis();
	w.println("# assembly file for "+name);
	w.println("# generated by AsmFileGenerator.java in fivmc");
	w.println("# based on a LinkableSet with "+code.size()+" linkables");
	w.println("# DO NOT EDIT DIRECTLY.");
	
	w.println("#include <fivmr_asm.h>");
        w.println("\t.file \""+filename+"\"");
        
        // gather sections
        HashMap< String, ArrayList< Linkable > > linkablesForSection=
            new HashMap< String, ArrayList< Linkable > >();
        
        for (Linkable l : code) {
            ArrayList< Linkable > list=linkablesForSection.get(l.asmSection());
            if (list==null) {
                linkablesForSection.put(l.asmSection(),list=new ArrayList< Linkable >());
            }
            list.add(l);
        }
	
	// generate definitions
        for (Map.Entry< String, ArrayList< Linkable > > e : linkablesForSection.entrySet()) {
            w.println();
            w.println();
            w.println("\t"+e.getKey());
            for (Linkable l : e.getValue()) {
                try {
                    StringWriter sw=new StringWriter();
                    PrintWriter psw=new PrintWriter(sw);
                    l.generateAsm(psw);
                    psw.flush();
                    String asm=sw.toString();
                    if (asm.length()>0) {
                        w.println();
                        w.print(asm);
                    }
                } catch (Throwable exc) {
                    throw new CompilerException("Failed to generate assembly for "+l,exc);
                }
            }
	}
        if (Global.verbosity>=1) {
            long after=System.currentTimeMillis();
            Global.log.println("I/O for "+name+" took "+(after-before)+" ms");
        }
    }
}
