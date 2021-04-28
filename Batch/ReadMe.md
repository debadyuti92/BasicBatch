`Simple Batch application with tasklets`

The BatchConfig file contains the job definitions and instantiates two tasklets.
The MyTaskOne.java is the initial tasklet which is used to read data from a file whose path
is added in the before step.
A dummy file is present in the resources.

MyTaskTwo is basically empty and can be used to perform some additional tasks.

Simply put, the business logic is to read a particular file from a location and then print it 
to the console.

PS: This is a very rudimentary app used for initial understanding.