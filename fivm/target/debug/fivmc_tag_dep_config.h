#undef FIVMR_ASSERTS_ON
#undef FIVMR_LOG_LEVEL

#define FIVMR_ASSERTS_ON 1
#if FIVMR_POSIX || FIVMR_WIN32
#define FIVMR_LOG_LEVEL 10
#else
#define FIVMR_LOG_LEVEL 0
#endif

