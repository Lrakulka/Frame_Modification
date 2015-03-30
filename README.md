Program modification frame from camera.
 Result:
 * Android gives to change copy of frame(use setPreviewCallback method of Camera)
 * Need to decode int array witch contains frame to rgb array
 * Some frames loses
Program written only for tests that is why I didn't organized properly work of activity cycle.
Also it can lock camera, restart of device helps to solve this problem.
