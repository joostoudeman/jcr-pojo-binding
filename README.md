[![Build Status](https://travis-ci.org/onehippo-forge/jcr-pojo-binding.svg?branch=master)](https://travis-ci.org/onehippo-forge/jcr-pojo-binding)

# JCR POJO Binding

This project aims to provide a simple set of POJO beans with which you can map JCR (document, binary, etc) nodes to POJO 
(ContentNode) beans, and also bind the POJO beans back to JCR (document, binary, etc) nodes. 

# Documentation 

Documentation is available at [onehippo-forge.github.io/jcr-pojo-binding](https://onehippo-forge.github.io/jcr-pojo-binding)

The online documentation is generated by this command from the master branch:

 > mvn -Pgithub.pages clean site:site
 
The output is in the ```/docs``` directory; push it and GitHub Pages will serve the site automatically. 

For rendering documentation on non-master branches, use the normal site command so the output will be in the ```/target``` 
and therefore ignored by Git.

 > mvn clean site:site
