make:

run: src/Server.java
	@-javac src/Server.java -d bin -sourcepath src/
	@-java -classpath /home/wyatt/Documents/Projects/ChatClient/bin Server

client: src/Client.java
	@-javac src/Client.java -d bin -sourcepath src/
	@-java -classpath /home/wyatt/Documents/Projects/ChatClient/bin Client

manager: src/ClientManager.java
	@-javac src/ClientManager.java -d bin -sourcepath src/
	@-java -classpath /home/wyatt/Documents/Projects/ChatClient/bin ClientManager