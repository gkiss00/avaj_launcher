all :				
					javac ./srcs/Simulation.javac
					java ./srcs/SImulation scenario.txt


clean :				
					rm -rf ./srcs/*.class
					rm -rf ./srcs/model/*.class
					rm -rf ./srcs/exception/*.class


.PHONY:				all clean