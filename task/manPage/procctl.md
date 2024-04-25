
# **Name : _processControleApp_**

# \_ \_ \_ \_ \_ \_ \_ \_ \_ \_ \_ \_ \_ \_  

# 
## **Purpose** 
this app developed to manage some process features like:  

* list process  
* send signal to process


# \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_

# 
## **Usage** 

### To use the app
> ./processControleApp 

### To See Help Menu
> ./processControleApp -h 


# \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_

#

# Options
1. Show process list.   
   Displays a list of running processes.
2. Show group list.  
   Displays a list of process groups.
3. Show ID list.  
  Displays a list of process IDs.
4. Run and stop.  
  Allows the user to run a command and kill the process if needed.
5. Signals.  
 Allows the user to send signals to a process (SIGINT, SIGHUP, SIGSTOP, SIGCONT).

# \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_


# 
## **Signals List** 

* SIGHUP    - signal is reloading configuration and restarting process

 ______________________________________________

* SIGINT    - signal is commonly used to request the termination of a process in a controlled manner, allowing the process to clean up and exit gracefully.

______________________________________________

* SIGQUIT   - signal is commonly used to request the termination of a process in a manner that allows for debugging and analysis of its state at the time of termination.

______________________________________________

* SIGTRAP   - signal is primarily used by debuggers to interrupt a process in order to perform debugging operations such as setting breakpoints, tracing system calls, or handling errors. It is not commonly used in regular application programming

______________________________________________

* SIGABRT   - signal is typically used to indicate an abnormal termination condition and is often raised in response to critical errors or failures that require the process to be terminated in a controlled manner.

______________________________________________

* SIGKILL   - signal is a powerful tool for forcefully terminating processes that are unresponsive or misbehaving. However, it should be used carefully due to its immediate and unignorable nature.

______________________________________________

* SIGTERM   - signal is commonly used to request a process to terminate in a controlled and graceful manner, allowing it to clean up resources and perform any necessary actions before exiting. It is a standard way to stop a process without abruptly ending its execution.

______________________________________________

* SIGCONT   - signal is used to resume the execution of a stopped or paused process, allowing it to continue running. It is commonly used in scenarios where processes need to be temporarily halted and then resumed based on external events or user interactions

______________________________________________

* SIGSTOP   - signal is used to pause (suspend) the process 


# \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_

# 
## See Also
> ps(1) , kill(1), pkill(1)

#### Author
**_Team 28_**
