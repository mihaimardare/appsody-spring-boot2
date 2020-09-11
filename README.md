  
  ## install appsody
  brew install appsody/appsody/appsody

  ## install tektoncd-cli
  brew tap tektoncd/tools
  brew install tektoncd/tools/tektoncd-cli

  ## Add Stacks to appsody
  appsody repo add kabanero https://github.com/kabanero-io/collections/releases/download/0.3.5/kabanero-index.yaml

  ## list repos
  appsody repo list

  ## list kabanero stack
  appsody list kabanero

  ## set kabanero repo as default
  appsody repo set-default kabanero

  ## Initialize the project using appsody init by selecting the desired stack ID template simple
  appsody init kabanero/java-spring-boot2

  ## Build the application
  ## This command will locally build a docker image of your appsody project.
  appsody build

  ## Test the Application
  ## Test the application using appsody
  ## This step is building a container and running the test command inside of it.
  appsody test

  ## Run the Application
  ## Run the application using appsody
  ## This step is building a container and running it, the output has the endpoint for the application.
  appsody run

  ## Stop the Application
  ## To stop the application container, run this command.
  appsody stop
  ## Alternatively, you can also press Ctrl+C.

  ## To debug the application including reloading the application on code changes run the below command.
  appsody debug

  ## Appsody tasks on VS Code
  ## To access the build tasks on VS code, go to
  Terminal > Run Build Task...

  ## Codewind on VS Code
  ## Once you get them installed, let us now open the Codewind in the IDE.
  View > Open View...





  