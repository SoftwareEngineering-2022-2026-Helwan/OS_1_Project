#ifndef COMMAND_H_INCLUDED
#define COMMAND_H_INCLUDED

typedef char* String;


// |---------( Process Display Command )---------|

const String PS = "ps ";
const String PS_USER_OPTION = " -U ";
const String PS_ALL_OPTION = " aux | less";
const String PS_IDS_OPTION = " ax -o pid | less";


// |---------( Process Control Command )---------|

const String PKILL = "pkill -of -";

//kill method
const String KILL = "kill -s ";
const String SET_PROCESS_NAME = "PROCESS_NAME=\"";
const String CLOSE_QUOTE = "\"";
const String GET_PROCESS_ID =" $( ps -o pid= -C $PROCESS_NAME )";

//start background process
const String START_BACKGROUND_PROCESS_PART1 = "( ";
const String START_BACKGROUND_PROCESS_PART2 = " 2> log  &) ";

// validate process start 
const String IS_PROCESS_UP_PART1 = "if [ \"$(ps -o pid= -C ";
const String IS_PROCESS_UP_PART2 = " )\" = \"\" ]; then echo \"\n[^] Process Name May Be Wrong\n\" ;else echo \"\n[^] Process Status: Running\n\";fi";

// |---------( Singals )---------|

const String SIG_STOP = "STOP ";
const String SIG_INTURUPT = "INT ";
const String SIG_ABORT = "ABRT ";
const String SIG_QUIT = "QUIT ";
const String SIG_CONTINUE = "CONT ";
const String SIG_TERMINATE = "TERM ";
const String SIG_KILL = "KILL ";
const String SIG_HANGUP = "HUP ";
const String SIG_TRAP = "TRAP ";

#endif
