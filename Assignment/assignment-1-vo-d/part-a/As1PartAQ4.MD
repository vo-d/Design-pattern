##VideoStrategy
###In order to create a new feature VideoStrategy, we must do the following:
1. Identify the algorithm that have a tendency to change by condition. In this case, it is the algorithm in VideoStrategy.
2. Write the interface for the algorithm and all of its variables.
3. Implement the algorithm into **VideoCapture** and **NoVideo** classes, then modify the algorithm them by your will.
4. In the context class, which is **CameraApp**, add a field that will for storing **VideoStrategy** object. Then, write a *setter* for that field.
5. Then, in each of the children class, which is **BasicCameraApp** and **PremiumCameraApp**, we must associate them with a strategy that is suitable.
##Done!!
:+1: 
