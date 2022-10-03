This example was created following Baeldung example:

https://www.baeldung.com/maven-plugin

As with Baeldung though, it is almost never complete. So, the following solution was used from stackoverflow to 
made the project start working:

https://stackoverflow.com/questions/14403669/why-can-maven-not-find-my-custom-mojo

Apparently, this is an issue with Maven since 2013, and with every release Maven'd say it was fixed, 
when in reality it wasn't. Unfortunately, this didn't work either and Maven couldn't find my Mojo.

Then I followed the example closely from this repository, and copied most of pom.xml settings from it to find where was the issue.

https://github.com/oktadev/example-maven-plugin

Eventually, I found the real issue was that my project folder structure did not have "/src/java/main" and my packages
were floating in the root of the directory, which Maven did not take kindly.

<build>
    <pluginManagement>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-plugin-plugin</artifactId>
                <version>3.2</version>
                <configuration>
                    <skipErrorNoDescriptorsFound>true</skipErrorNoDescriptorsFound>
                </configuration>
                <executions>
                    <execution>
                        <id>mojo-descriptor</id>
                        <phase>process-classes</phase>
                        <goals>
                            <goal>descriptor</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </pluginManagement>
</build>

This is the first base working example. 

**Steps to use:**

1. clone and download
2. mvn clean install
3. from any project, execute the following command:
- $ mvn com.aabut:counter-maven-plugin:1.0-SNAPSHOT:counter
