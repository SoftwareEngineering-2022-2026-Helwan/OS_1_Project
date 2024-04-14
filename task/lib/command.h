#ifndef COMMAND_H_INCLUDED
#define COMMAND_H_INCLUDED

typedef char* String;


// |---------( Process Display Command )---------|

const String PS = "ps ";
const String PS_GROUP_OPTION = " -G ";
const String PS_ALL_OPTION = " aux ";
const String PS_IDS_OPTION = " -A -o pid= ";


// |---------( Process Control Command )---------|

const String KILL = "kill -s ";
const String SET_PROCESS_NAME = "PROCESS_NAME=\"";
const String CLOSE_QUOTE = "\"";
const String GET_PROCESS_ID =" $( ps -o pid= -C $PROCESS_NAME )";

// |---------( Singals )---------|

const String SIG_STOP = " STOP ";
const String SIG_INTURUPT = " INT ";
const String SIG_ABORT = " ABRT ";
const String SIG_QUIT = " QUIT ";
const String SIG_CONTINUE = " CONT ";
const String SIG_TERMINATE = " TERM ";
const String SIG_KILL = " KILL ";
const String SIG_HANGUP = " HUP ";
const String SIG_TRAP = " TRAP ";





/*
 [!] Other Non Common Use Signals 

 ILL  BUS FPE  USR1 SEGV USR2 PIPE ALRM  STKFLT CHLD  TSTP TTIN TTOU URG XCPU XFSZ VTALRM PROF WINCH POLL PWR SYS

*/


#endif
