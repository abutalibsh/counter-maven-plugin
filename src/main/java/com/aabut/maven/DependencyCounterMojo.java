package src.main.java.com.aabut.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

@Mojo(name = "counter", defaultPhase = LifecyclePhase.INITIALIZE)
public class DependencyCounterMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", readonly = true)
    MavenProject project;

    @Parameter(property = "scope", defaultValue = "fdkasjfsdkrewpoiruew")
    String scope;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        List dependencies = project.getDependencies();
        getLog().info("Set scope is: " + scope);
        getLog().info("Total number of dependencies is: " + dependencies.size());
    }
}
