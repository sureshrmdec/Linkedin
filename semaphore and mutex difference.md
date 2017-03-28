They are NOT the same thing. They are used for different purposes!
While both types of semaphores have a full/empty state and use the same API, their usage is very different.

Mutual Exclusion Semaphores
Mutual Exclusion semaphores are used to protect shared resources (data structure, file, etc..).

A Mutex semaphore is "owned" by the task that takes it. If Task B attempts to semGive a mutex currently held by Task A, Task B's call will return an error and fail.

Mutexes always use the following sequence:

  - SemTake
  - Critical Section
  - SemGive
Here is a simple example:

  Thread A                     Thread B
   Take Mutex
     access data
     ...                        Take Mutex  <== Will block
     ...
   Give Mutex                     access data  <== Unblocks
                                  ...
                                Give Mutex
Binary Semaphore
Binary Semaphore address a totally different question:

Task B is pended waiting for something to happen (a sensor being tripped for example).
Sensor Trips and an Interrupt Service Routine runs. It needs to notify a task of the trip.
Task B should run and take appropriate actions for the sensor trip. Then go back to waiting.

   Task A                      Task B
   ...                         Take BinSemaphore   <== wait for something
   Do Something Noteworthy
   Give BinSemaphore           do something    <== unblocks
Note that with a binary semaphore, it is OK for B to take the semaphore and A to give it.
Again, a binary semaphore is NOT protecting a resource from access. The act of Giving and Taking a semaphore are fundamentally decoupled.
It typically makes little sense for the same task to so a give and a take on the same binary semaphore.




Mutex can be released only by thread that had acquired it, while you can signal semaphore from any other thread (or process), 
so semaphores are more suitable for some synchronization problems like producer-consumer.

On Windows, binary semaphores are more like event objects than mutexes.






Mutex:

Is a key to a toilet. One person can have the key - occupy the toilet - at the time. When finished, 
the person gives (frees) the key to the next person in the queue.

Officially: "Mutexes are typically used to serialise access to a section of re-entrant code that cannot be executed concurrently
by more than one thread. A mutex object only allows one thread into a controlled section, 
forcing other threads which attempt to gain access to that section to wait 
until the first thread has exited from that section." Ref: Symbian Developer Library
(A mutex is really a semaphore with value 1.)

Semaphore:

Is the number of free identical toilet keys. Example, say we have four toilets with identical locks and keys. 
The semaphore count - the count of keys - is set to 4 at beginning (all four toilets are free), 
then the count value is decremented as people are coming in. If all toilets are full, ie. 
there are no free keys left, the semaphore count is 0. Now, when eq. one person leaves the toilet, 
semaphore is increased to 1 (one free key), and given to the next person in the queue.



Officially: "A semaphore restricts the number of simultaneous users of a shared resource up to a maximum number. 
Threads can request access to the resource (decrementing the semaphore), 
and can signal that they have finished using the resource (incrementing the semaphore)." Ref: Symbian Developer Library
