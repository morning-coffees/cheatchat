# cheatchat
Flutter test application. Main functionality is to be able to chat someone or in a group with temporary message. Messages will not be saved and in order to join a convo, you just need to have the chat code.


# Front-End: Flutter (cheatchatfe folder)
* If you are new to flutter, follow this link to setup your local flutter. There are also instructions there on how to run a flutter project. https://docs.flutter.dev/get-started/install
* If you are just trying to run the project, I suggest you use visual studio code or android studio.
	- import the project to your favorite ide
	- setup device
		> Run `flutter doctor` to see the devices are connected/discovered
		
		> If you want to run on actual device, make sure your device are on debug mode, connected to machine(laptop), and discovered by flutter doctor
		
		> If you want to run on browser, no need to setup. Just make sure you have your browser installed and run the project. Also run flutter doctor to make sure browser is discovered.


# Front-End: Javascript
* Javascript frontend will automatically run with the Backend, this is just a test site and the real Front-End is run using Flutter


# Back-End: Spring Boot (cheatchatbe folder)
* If you are new to spring boot, follow this guide and make sure to use maven. https://spring.io/guides/gs/spring-boot/
* If you just want to run the project, I suggest you use Eclipse
	- import the cheatchatbe folder to eclipse (import as maven project)
	- run `mvn clean install` to download dependencies. In eclipse,  you can also `right click the cheatchatbe folder > Maven > Update Project > Check Project > Ok`
	
	
