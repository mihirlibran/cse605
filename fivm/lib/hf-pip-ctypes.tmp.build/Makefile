CC=gcc
CPPFLAGS= -DHAVE_CONFIG_H   -D_REENTRANT -D_GNU_SOURCE -I'/home/scottflo/fivm/runtimec/src' -I'/home/scottflo/fivm/lib/targets/POSIX-linux-gnu-i686-32' -I. -DFIVMBUILD_SPECIALIZING=1 -DFIVMC_COMPILE=1
CFLAGS=  -m32 -m32 -march=i686   -g   -Wno-unused-command-line-argument -O3 -fno-strict-aliasing -fno-optimize-sibling-calls -fomit-frame-pointer -falign-loops -fwrapv -momit-leaf-frame-pointer -msse2 -mfpmath=sse -fno-pic 
LDFLAGS=   -m32 -m32 -march=i686
LIBS=-lpthread -ldl -lm 
HOMEDIR=/home/scottflo/fivm
RTTARGS=
LINKDYNAMIC=
EXTRAINCLUDES=
all: computeOffsets
clean:
	rm -f computeOffsets *.o
computeOffsets: computeOffsets.o
	$(CC) -o computeOffsets computeOffsets.o $(LDFLAGS) $(LIBS)
computeOffsets.o: computeOffsets.c fivmc_compile_info.h fivmc_config.h fivmc_c1_config.h fivmc_extra_includes.h
	$(CC) -c -o computeOffsets.o computeOffsets.c ${CPPFLAGS} ${CFLAGS} ${addlcflags}
