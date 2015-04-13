/*
 * PatchSubGenerator.java
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

package com.fiji.fivm.codegen.x86;

import com.fiji.fivm.r1.*;
import com.fiji.fivm.codegen.*;
import static com.fiji.fivm.r1.fivmRuntime.*;

public final class PatchSubGenerator extends SubGenerator {
    Pointer debugID;
    boolean debugIDStored;
    int stackHeight;
    int offsetToJStack;
    
    public PatchSubGenerator(Pointer methodRec,
                             X86Assembler asm,
                             DebugIDAllocator dida,
                             int stackHeight,
                             Pointer debugID,
                             boolean debugIDStored) {
        super(methodRec,asm,dida);
        this.stackHeight=stackHeight;
        this.offsetToJStack=fivmr_Baseline_offsetToJStack(methodRec);
        this.debugID=debugID;
        this.debugIDStored=debugIDStored;
    }
    
    public Pointer debugID(int stackDelta) {
        return dida.debugIDWithRootSize(debugID,nRoots(stackDelta));
    }
    
    public boolean debugIDStored() {
        return debugIDStored;
    }
    
    public int offsetOfEsp() {
        return offsetToJStack-stackHeight*4;
    }
    
    public int stackHeight() {
        return stackHeight;
    }
}

