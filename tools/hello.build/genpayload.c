/* C file for payload */
/* generated by CFileGenerator.java in fivmc */
/* based on a LinkableSet with 143 linkables */
/* DO NOT EDIT DIRECTLY. */
#include <fivmr.h>
extern fivmr_Payload hello_payload;
extern uintptr_t hello_stringIndex[];
extern fivmr_TypeData hello_TypeData_HelloArray_7dwDYrj8AK6FI7eP3KPgm8;
fivmr_StaticTypeContext hello_contexts[2];
extern fivmr_Configuration hello_config;
int64_t hello_staticPrimFields[10];
fivmr_Object hello_staticRefFields[101];
bool hello_postThreadInitCback(fivmr_ThreadState *ts);
extern uintptr_t hello_typeList[];
extern fivmr_TypeStub hello_stubList[];
extern uintptr_t hello_degugTable[];
extern uintptr_t hello_stringTable[];
extern uintptr_t hello_stringDataArray[];
extern uintptr_t hello_classTable[];
extern fivmr_TypeData hello_TypeData_top_bkcp4oGc4D8yEEH7nlTJj6;
extern fivmr_TypeData hello_TypeData_doubleArr_mjlqzFmth2EYGUJjMUzYX3;
extern fivmr_TypeData hello_TypeData_pointer_sEgXFRMZ4QGvR8UkdPirt7;
extern fivmr_TypeData hello_TypeData_vm_FCPtr_RXJlkedCSLtbjp4C2SYZW2;
extern fivmr_TypeData hello_TypeData_Cloneable_e2xIx7PUe02GksGcFKFkr8;
extern fivmr_TypeData hello_TypeData_Class_GPw2KraYNcgDw88XQsM0a2;
extern fivmr_TypeData hello_TypeData_boolean_sY8z6fx1V8ILNqgtWTEA35;
extern fivmr_TypeData hello_TypeData_Object_QdKWySJdodzDYbV6VD2VJ;
extern fivmr_TypeData hello_TypeData_char_GiXZWB9j4vBLRwx6WJyV86;
extern fivmr_TypeData hello_TypeData_pointerArr_mPM8X1CMEIVbdR2ahlrD34;
extern fivmr_TypeData hello_TypeData_StringArr_847AxcZu9gWRJWNEN8DQu5;
extern fivmr_TypeData hello_TypeData_floatArr_5YlNatn3OVHrdzH9hfwKk5;
extern fivmr_TypeData hello_TypeData_ClassArr_lBldaXgGN9Gu5f4Ma9ms16;
extern fivmr_TypeData hello_TypeData_ObjectArr_v26WGLx6a25VP6bXhOLzB5;
extern fivmr_TypeData hello_TypeData_intArr_wA4JCC2DA3AFo22aSDOZ76;
extern fivmr_TypeData hello_TypeData_double_9qhcjlYcEbW7W8Wvd29o68;
extern fivmr_TypeData hello_TypeData_byteArr_nhLAxLkni0PhWM81bwqQW7;
extern fivmr_TypeData hello_TypeData_vm_FCPtrArr_0jAH6IfIHGlY2R2kAFpWf7;
extern fivmr_TypeData hello_TypeData_Serializable_w2dIMIasUW2jzZi7BO5Wu7;
extern fivmr_TypeData hello_TypeData_shortArr_O9QqSxVPUYeTdeZkUTYxS2;
extern fivmr_TypeData hello_TypeData_booleanArr_gfzXZt9jGBwenAc28FEfS6;
extern fivmr_TypeData hello_TypeData_charArr_l3vFjwWeWLchNa4tr5HoK5;
extern fivmr_TypeData hello_TypeData_longArr_IyYJgAzIvmrHWyFYSA0Nh5;
extern fivmr_TypeData hello_TypeData_WeakReference_aIuqrQ3Ad6912mgziklPD2;
extern fivmr_TypeData hello_TypeData_int_gv1gSVUGP0dW3cdLM7LmE8;
extern fivmr_TypeData hello_TypeData_byte_p0EiuVgIFBYQneSwHkWxN2;
extern fivmr_TypeData hello_TypeData_String_WHsiOUfdh3VfAocbciMXp7;
extern fivmr_TypeData hello_TypeData_short_31w3AaWO7w89oLerGEZ9h3;
extern fivmr_TypeData hello_TypeData_float_jYAb064TTl5ULSaM45eom3;
extern fivmr_TypeData hello_TypeData_long_ODGjCjLuSmdgk1yysabXl;
extern fivmr_TypeData hello_TypeData_void_au552JrSiVdXJTpoUumvq7;
void hello_fivmRuntime_initSystemClassLoaders(uintptr_t arg0);
void hello_fivmRuntime_notifyInitialized(uintptr_t arg0);
void hello_returnBuffer(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_getCString(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_getCStringFull(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_fromCStringInHeap(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_fromCStringFullInHeap(uintptr_t arg0,uintptr_t arg1);
void hello_fivmRuntime_boot(uintptr_t arg0);
void hello_throwArithmeticRTE(uintptr_t arg0);
void hello_throwArithmeticRTE_inJava(uintptr_t arg0);
void hello_throwNullPointerRTE(uintptr_t arg0);
void hello_throwNullPointerRTE_inJava(uintptr_t arg0);
void hello_throwStackOverflowRTE(uintptr_t arg0);
void hello_throwStackOverflowRTE_inJava(uintptr_t arg0);
void hello_throwArrayBoundsRTE_inJava(uintptr_t arg0);
void hello_throwArrayStoreRTE_inJava(uintptr_t arg0);
void hello_throwNegativeSizeRTE_inJava(uintptr_t arg0);
void hello_throwClassCastRTE_inJava(uintptr_t arg0);
void hello_throwClassChangeRTE_inJava(uintptr_t arg0);
void hello_throwNoClassDefFoundError_inJava(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2);
void hello_throwNoClassDefFoundError_inNative(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2);
void hello_throwLinkageError_inJava(uintptr_t arg0,uintptr_t arg1);
void hello_throwIllegalAssignmentError(uintptr_t arg0);
void hello_throwIllegalAssignmentError_inJava(uintptr_t arg0);
void hello_throwAbstractMethodError_inJava(uintptr_t arg0);
void hello_throwUnsatisfiedLinkErrorForLoad(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2);
void hello_throwExceptionInInitializerError_inJava(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2);
void hello_throwReflectiveException_inJava(uintptr_t arg0,uintptr_t arg1);
void hello_throwOutOfMemoryError_inJava(uintptr_t arg0);
void hello_throwIllegalMonitorStateException_inJava(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_fromUTF16Sequence(uintptr_t arg0,uintptr_t arg1,int32_t arg2);
int32_t hello_stringLength(uintptr_t arg0,uintptr_t arg1);
int32_t hello_cstringLength(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_getUTF16Sequence(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_getBooleanElements(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_getByteElements(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_getCharElements(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_getShortElements(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_getIntElements(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_getLongElements(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_getFloatElements(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_getDoubleElements(uintptr_t arg0,uintptr_t arg1);
void hello_returnBooleanElements(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2,int32_t arg3);
void hello_returnByteElements(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2,int32_t arg3);
void hello_returnCharElements(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2,int32_t arg3);
void hello_returnShortElements(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2,int32_t arg3);
void hello_returnIntElements(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2,int32_t arg3);
void hello_returnLongElements(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2,int32_t arg3);
void hello_returnFloatElements(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2,int32_t arg3);
void hello_returnDoubleElements(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2,int32_t arg3);
void hello_getBooleanRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_getByteRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_getCharRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_getShortRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_getIntRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_getLongRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_getFloatRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_getDoubleRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_setBooleanRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_setByteRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_setCharRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_setShortRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_setIntRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_setLongRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_setFloatRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_setDoubleRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_throwInternalError(uintptr_t arg0,uintptr_t arg1);
void hello_throwNoSuchFieldError(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2);
void hello_throwNoSuchMethodError(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2);
void hello_throwNoSuchMethodError_inJava(uintptr_t arg0,uintptr_t arg1);
void hello_describeExceptionImpl(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_VMThread_create(uintptr_t arg0,int32_t arg1,int8_t arg2);
uintptr_t hello_VMThread_createRT(uintptr_t arg0,int32_t arg1,int8_t arg2);
void hello_VMThread_setThreadState(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2);
uintptr_t hello_VMThread_getThreadState(uintptr_t arg0,uintptr_t arg1);
void hello_VMThread_starting(uintptr_t arg0,uintptr_t arg1);
void hello_VMThread_run(uintptr_t arg0,uintptr_t arg1);
int8_t hello_VMThread_setUncaughtException(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2);
void hello_VMThread_die(uintptr_t arg0,uintptr_t arg1);
int32_t hello_VMThread_getPriority(uintptr_t arg0,uintptr_t arg1);
int8_t hello_VMThread_isDaemon(uintptr_t arg0,uintptr_t arg1);
void hello_makeJNIFuncName(uintptr_t arg0,uintptr_t arg1,int32_t arg2,uintptr_t arg3,int8_t arg4);
uintptr_t hello_processArgs(uintptr_t arg0,int32_t arg1,uintptr_t arg2);
void hello_getStringRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_getStringUTFRegion(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,uintptr_t arg4);
void hello_runRunnable(uintptr_t arg0,uintptr_t arg1);
void hello_javaExit(uintptr_t arg0,int32_t arg1);
uintptr_t hello_allocForNative(uintptr_t arg0,int32_t arg1,uintptr_t arg2);
uintptr_t hello_allocArrayForNative(uintptr_t arg0,int32_t arg1,uintptr_t arg2,int32_t arg3);
uintptr_t hello_String_getArrayPointer(uintptr_t arg0,uintptr_t arg1);
int32_t hello_String_getOffset(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_DirectByteBuffer_wrap(uintptr_t arg0,uintptr_t arg1,int32_t arg2,int32_t arg3,int32_t arg4);
uintptr_t hello_DirectByteBuffer_address(uintptr_t arg0,uintptr_t arg1);
int32_t hello_DirectByteBuffer_capacity(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_MemoryArea_getBSID(uintptr_t arg0,uintptr_t arg1);
uintptr_t hello_BackingStoreID_create(uintptr_t arg0,uintptr_t arg1);
void hello_MemoryArea_doRun(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2);
uintptr_t hello_DumpStackCback_cback(uintptr_t arg0,uintptr_t arg1,uintptr_t arg2,int32_t arg3);
static uint32_t usedTids[96] = {
   (uint32_t)INT32_C(2),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(-2),
   (uint32_t)INT32_C(-1),
   (uint32_t)INT32_C(-1),
   (uint32_t)INT32_C(3),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(-2),
   (uint32_t)INT32_C(16383),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(-2),
   (uint32_t)INT32_C(16383),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(-2),
   (uint32_t)INT32_C(1),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(-2),
   (uint32_t)INT32_C(4095),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(134217726),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(1022),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(30),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(30),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(6),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(6),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0),
   (uint32_t)INT32_C(0)
};
static int32_t itableOcc[9] = {
   INT32_C(8),
   INT32_C(4),
   INT32_C(4),
   INT32_C(4),
   INT32_C(3),
   INT32_C(2),
   INT32_C(2),
   INT32_C(2),
   INT32_C(2)
};
fivmr_Payload hello_payload = {
   "v0.9.1-rexported",
   "/home/scottflo/fivm",
   {
      {
         UINT32_C(1096360084)
,        UINT32_C(3751945)
      }
   },
   &hello_config,
   FIVMR_PL_IMMORTAL_ONESHOT,
   NULL,
   (int32_t)10,
   (int32_t)101,
   hello_staticPrimFields,
   hello_staticRefFields,
   (int32_t)7261,
   (int32_t)374,
   (uintptr_t)0,
   (int32_t)322,
   (int32_t)0,
   (int32_t)2,
   (int32_t)1121,
   (fivmr_TypeData**)hello_typeList,
   (fivmr_TypeStub*)(&hello_stubList),
   hello_contexts,
   (fivmr_DebugRec*)hello_degugTable,
   (uintptr_t*)hello_stringTable,
   (uintptr_t*)hello_stringDataArray,
   NULL,
   (fivmr_Object*)(void*)hello_stringIndex,
   (uintptr_t*)hello_classTable,
   (uintptr_t)(intptr_t)-4,
   (uintptr_t)(intptr_t)-4,
   "hello",
   (&hello_TypeData_HelloArray_7dwDYrj8AK6FI7eP3KPgm8),
   usedTids,
   (uintptr_t)12,
   itableOcc,
   (uintptr_t)9,
   NULL,
   0,
   NULL,
   hello_postThreadInitCback
,  (fivmr_TypeData*)(&hello_TypeData_top_bkcp4oGc4D8yEEH7nlTJj6)
,  (fivmr_TypeData*)(&hello_TypeData_void_au552JrSiVdXJTpoUumvq7)
,  (fivmr_TypeData*)(&hello_TypeData_boolean_sY8z6fx1V8ILNqgtWTEA35)
,  (fivmr_TypeData*)(&hello_TypeData_byte_p0EiuVgIFBYQneSwHkWxN2)
,  (fivmr_TypeData*)(&hello_TypeData_char_GiXZWB9j4vBLRwx6WJyV86)
,  (fivmr_TypeData*)(&hello_TypeData_short_31w3AaWO7w89oLerGEZ9h3)
,  (fivmr_TypeData*)(&hello_TypeData_int_gv1gSVUGP0dW3cdLM7LmE8)
,  (fivmr_TypeData*)(&hello_TypeData_long_ODGjCjLuSmdgk1yysabXl)
,  (fivmr_TypeData*)(&hello_TypeData_float_jYAb064TTl5ULSaM45eom3)
,  (fivmr_TypeData*)(&hello_TypeData_double_9qhcjlYcEbW7W8Wvd29o68)
,  (fivmr_TypeData*)(&hello_TypeData_pointer_sEgXFRMZ4QGvR8UkdPirt7)
,  (fivmr_TypeData*)(&hello_TypeData_vm_FCPtr_RXJlkedCSLtbjp4C2SYZW2)
,  (fivmr_TypeData*)(&hello_TypeData_Object_QdKWySJdodzDYbV6VD2VJ)
,  (fivmr_TypeData*)(&hello_TypeData_String_WHsiOUfdh3VfAocbciMXp7)
,  (fivmr_TypeData*)(&hello_TypeData_Class_GPw2KraYNcgDw88XQsM0a2)
,  (fivmr_TypeData*)(&hello_TypeData_Serializable_w2dIMIasUW2jzZi7BO5Wu7)
,  (fivmr_TypeData*)(&hello_TypeData_Cloneable_e2xIx7PUe02GksGcFKFkr8)
,  NULL
,  NULL
,  NULL
,  (fivmr_TypeData*)(&hello_TypeData_WeakReference_aIuqrQ3Ad6912mgziklPD2)
,  (fivmr_TypeData*)(&hello_TypeData_booleanArr_gfzXZt9jGBwenAc28FEfS6)
,  (fivmr_TypeData*)(&hello_TypeData_byteArr_nhLAxLkni0PhWM81bwqQW7)
,  (fivmr_TypeData*)(&hello_TypeData_charArr_l3vFjwWeWLchNa4tr5HoK5)
,  (fivmr_TypeData*)(&hello_TypeData_shortArr_O9QqSxVPUYeTdeZkUTYxS2)
,  (fivmr_TypeData*)(&hello_TypeData_intArr_wA4JCC2DA3AFo22aSDOZ76)
,  (fivmr_TypeData*)(&hello_TypeData_longArr_IyYJgAzIvmrHWyFYSA0Nh5)
,  (fivmr_TypeData*)(&hello_TypeData_floatArr_5YlNatn3OVHrdzH9hfwKk5)
,  (fivmr_TypeData*)(&hello_TypeData_doubleArr_mjlqzFmth2EYGUJjMUzYX3)
,  (fivmr_TypeData*)(&hello_TypeData_pointerArr_mPM8X1CMEIVbdR2ahlrD34)
,  (fivmr_TypeData*)(&hello_TypeData_vm_FCPtrArr_0jAH6IfIHGlY2R2kAFpWf7)
,  (fivmr_TypeData*)(&hello_TypeData_ObjectArr_v26WGLx6a25VP6bXhOLzB5)
,  (fivmr_TypeData*)(&hello_TypeData_StringArr_847AxcZu9gWRJWNEN8DQu5)
,  (fivmr_TypeData*)(&hello_TypeData_ClassArr_lBldaXgGN9Gu5f4Ma9ms16)
,  hello_fivmRuntime_boot
,  hello_fivmRuntime_initSystemClassLoaders
,  hello_fivmRuntime_notifyInitialized
,  hello_allocForNative
,  hello_allocArrayForNative
,  hello_throwInternalError
,  hello_throwNoClassDefFoundError_inNative
,  hello_throwNoClassDefFoundError_inJava
,  hello_throwLinkageError_inJava
,  hello_throwNullPointerRTE
,  hello_throwNullPointerRTE_inJava
,  hello_throwArithmeticRTE
,  hello_throwArithmeticRTE_inJava
,  hello_throwStackOverflowRTE
,  hello_throwStackOverflowRTE_inJava
,  hello_throwClassChangeRTE_inJava
,  hello_throwArrayBoundsRTE_inJava
,  hello_throwArrayStoreRTE_inJava
,  hello_throwNegativeSizeRTE_inJava
,  hello_throwAbstractMethodError_inJava
,  hello_throwClassCastRTE_inJava
,  hello_throwUnsatisfiedLinkErrorForLoad
,  hello_throwNoSuchFieldError
,  hello_throwNoSuchMethodError
,  hello_throwNoSuchMethodError_inJava
,  hello_throwExceptionInInitializerError_inJava
,  hello_throwReflectiveException_inJava
,  hello_throwIllegalMonitorStateException_inJava
,  hello_throwOutOfMemoryError_inJava
,  hello_throwIllegalAssignmentError
,  hello_throwIllegalAssignmentError_inJava
,  hello_describeExceptionImpl
,  hello_fromCStringInHeap
,  hello_fromCStringFullInHeap
,  hello_fromUTF16Sequence
,  hello_stringLength
,  hello_cstringLength
,  hello_getUTF16Sequence
,  hello_getCString
,  hello_getCStringFull
,  hello_getStringRegion
,  hello_getStringUTFRegion
,  hello_String_getArrayPointer
,  hello_String_getOffset
,  hello_getBooleanElements
,  hello_getByteElements
,  hello_getCharElements
,  hello_getShortElements
,  hello_getIntElements
,  hello_getLongElements
,  hello_getFloatElements
,  hello_getDoubleElements
,  hello_returnBooleanElements
,  hello_returnByteElements
,  hello_returnCharElements
,  hello_returnShortElements
,  hello_returnIntElements
,  hello_returnLongElements
,  hello_returnFloatElements
,  hello_returnDoubleElements
,  hello_getBooleanRegion
,  hello_getByteRegion
,  hello_getCharRegion
,  hello_getShortRegion
,  hello_getIntRegion
,  hello_getLongRegion
,  hello_getFloatRegion
,  hello_getDoubleRegion
,  hello_setBooleanRegion
,  hello_setByteRegion
,  hello_setCharRegion
,  hello_setShortRegion
,  hello_setIntRegion
,  hello_setLongRegion
,  hello_setFloatRegion
,  hello_setDoubleRegion
,  hello_returnBuffer
,  hello_DirectByteBuffer_wrap
,  hello_DirectByteBuffer_address
,  hello_DirectByteBuffer_capacity
,  hello_VMThread_create
,  hello_VMThread_createRT
,  hello_VMThread_setThreadState
,  hello_VMThread_getThreadState
,  hello_VMThread_starting
,  hello_VMThread_run
,  hello_VMThread_setUncaughtException
,  hello_VMThread_die
,  hello_VMThread_isDaemon
,  hello_VMThread_getPriority
,  hello_DumpStackCback_cback
,  hello_makeJNIFuncName
,  hello_runRunnable
,  hello_MemoryArea_doRun
,  hello_MemoryArea_getBSID
,  NULL  /* resolution canceled for fivmRuntime_loadClass */
,  NULL  /* resolution canceled for handlePatchPointImpl */
,  NULL  /* resolution canceled for handleLoadThunk */
,  NULL  /* resolution canceled for allocateClass */
,  NULL  /* resolution canceled for handleFieldResolution */
,  NULL  /* resolution canceled for handleMethodResolution */
,  NULL  /* resolution canceled for handleArrayAlloc */
,  NULL  /* resolution canceled for handleObjectAlloc */
,  NULL  /* resolution canceled for handleInstanceof */
,  hello_BackingStoreID_create
,  hello_processArgs
,  hello_javaExit
};
fivmr_StaticTypeContext hello_contexts[2] = {
   { 0, 320, 0, 0, &hello_payload },
   { 320, 2, 0, 0, &hello_payload }
};