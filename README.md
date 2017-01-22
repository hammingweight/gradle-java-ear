# gradle-java-ear
An example Gradle project to build a Java EE EAR. This project is based on sample
code by Danny Coward from "Java EE 7: The Big Picture", Oracle Press, 2015.

This project contains a root project that builds an EAR. There are two sub-projects
to build an EJB JAR and a WAR.

To build the project run
    gradle build
or
    gradle ear

The resultant EAR will be generated in the build/libs directory.

The EAR file can be deployed to a Java EE Application Server. To access the
servlet using a default configuration, point your browser to
    http://<glassfish_ip:8080>/war/DisplayServlet

