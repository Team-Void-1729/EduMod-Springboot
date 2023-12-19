package org.aot.edumoduler.git;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;


public class VersionControl {
	public void initRepo() throws GitAPIException {
		Git.init()
		.setDirectory(new File("/JGit/repo"))
		.call();
	}
	
	public void cloneRepo() throws GitAPIException, InvalidRemoteException, TransportException {
		Git.cloneRepository()
        .setURI("https://github.com/Resourcio-Community/apertre")
        .setDirectory(new File("/JGit/clone")) 
        .setCloneAllBranches(true)
        .call();
	}
}