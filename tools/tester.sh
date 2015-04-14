#/bin/bash
#Compile Java File
FIJI_JAVA_COMPILER=$FIJI_HOME/ecj/ecj
HARDRTJSRC=/home/scottflo/repos/cse605/tools/src
$FIJI_JAVA_COMPILER -Xlint:unchecked -Xlint:deprecated -source 1.5 -target 1.5 -classpath lib/fijicore.jar:lib/fivmr.jar:lib/fivmcommon.jar:hardrtj/build:lib/fast-md5.jar $HARDRTJSRC -d src/build

#Compile Class File 
FIVM_LIB_DIR=$FIJI_HOME/lib
JARS=$FIVM_LIB_DIR/fivmtest.jar
JARS+=" "
#JARS+=$FIVM_LIB_DIR/rtsj.jar
echo "FijiVM Lib: " $FIVM_LIB_DIR
echo "CP: " $JARS
#fivmc --g-scoped-memory -o myprog -m com/fiji/fivm/test/RawScopedMemoryTest $JARS
#fivmc  -o myprog2 -m com/fiji/fivm/test/GetIntFieldTest $JARS
#fivmc -o hello src/build/test/Hello.class
fivmc -o hello src/build/test/HelloArray.class src/build/test/Kaymar.class --no-opt --rt-flowlog-enable