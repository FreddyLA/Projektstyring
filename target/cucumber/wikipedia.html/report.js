$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("use_cases\\create_activity.feature");
formatter.feature({
  "name": "Creating an activity",
  "description": "\tDescription: A project leader creates a new project\n\tActor: Project leader",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Create an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "When "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a new activity with the name \"Activity\" is created",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.aNewActivityWithTheNameIsCreated(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating an activity without being project leader",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a development worker creates an activity for the project",
  "keyword": "When "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerCreatesAnActivityForTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Action for project leader only\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases\\create_project.feature");
formatter.feature({
  "name": "Creating project",
  "description": "\tDescription: Testing project creation\n\tActors: Development worker",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Create a project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker is registered in the system",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aDevelopmentWorkerIsRegisteredInTheSystem()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a development worker creates a project with the name \"New Project\"",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectSteps.aDevelopmentWorkerCreatesANewProjectWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a new project is created with the name \"New Project\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.aNewProjectIsCreatedWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project is given a unique number for identification.",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.theProjectIsGivenAUniqueNumberForIdentification()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Create a project with the same name as a another project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a development worker creates a project with the name \"Project 1\"",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectSteps.aDevelopmentWorkerCreatesANewProjectWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Project with specified name already exists\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases\\edit_activity.feature");
formatter.feature({
  "name": "Change activity",
  "description": "Description: A project leader edits activies\nActor: Project leader",
  "keyword": "Feature"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader edits an activity\u0027s budgettet time",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the project leader changes budgettet time to 10",
  "keyword": "When "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderEditsActivity(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity\u0027s budgettet time is 10",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.theActivityIsChanged(int)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader edits an activity\u0027s start time",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the project leader changes the activity\u0027s start time",
  "keyword": "When "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderChangesTheActivitySStartTime()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity\u0027s start time has been changed",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.theActivitySStartTimeHasBeenChanged()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "A development worker edits an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker attempts to edit an activity\u0027s budgettet time",
  "keyword": "When "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerAttemptsToEditAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Action for project leader only\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Create an activity with deadline before start time",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the project leader changes the activity\u0027s start time",
  "keyword": "When "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderChangesTheActivitySStartTime()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader assigns a deadline to the activity that is before the assigned start date",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderAssignsAStartDateToTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Deadline cannot be before the assigned start date\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases\\edit_project.feature");
formatter.feature({
  "name": "Creating project",
  "description": "\tDescription: Testing project creation\n\tActors: Development worker",
  "keyword": "Feature"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader changes the project start date",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the project leader changes the project start date",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectSteps.theProjectLeaderChangesTheProjectStartDate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project start date has been changed",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.theProjectStartDateHasBeenChanged()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader changes the project start date",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the project leader changes the project end date",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectSteps.theProjectLeaderChangesTheProjectEndDate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project end date has been changed",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.theProjectEndDateHasBeenChanged()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Set the project start time to before project creation time",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the project leader assigns a start date for the project that is before the project creation date",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectSteps.theProjectLeaderAssignsAStartDateForTheProjectThatIsBeforeTheProjectCreationDate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Project start/end date cannot be before the project creation date\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Set the project end time to before project creation time",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the project leader assigns a end date for the project that is before the project creation date",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectSteps.theProjectLeaderAssignsAEndDateForTheProjectThatIsBeforeTheProjectCreationDate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Project start/end date cannot be before the project creation date\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Development worker tries to edit a project that does not exist",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker tries to edit a project that does not exist",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectSteps.aDevelopmentWorkerTriesToEditAProjectThatDoesNotExist()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Project with specified ID does not exist\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "A development worker that does not exist tries to edit a project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker that does not exist tries to edit a project",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectSteps.aDevelopmentWorkerThatDoesNotExistTriesToEditAProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Developer with specified initials does not exist\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases\\edit_registered_activity_time.feature");
formatter.feature({
  "name": "Edit previously registered data",
  "description": "Description: Development worker edits previously registered time on an activity\nActor: Development worker",
  "keyword": "Feature"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Editing previously registred time on an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker is assigned the activity",
  "keyword": "Given "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerIsAssignedTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker inputs 8 hours worked on the activity into the system",
  "keyword": "And "
});
formatter.match({
  "location": "RegisterTimeSteps.theDevelopmentWorkerInputsAmountOfHoursWorkedForTheDayIntoTheSystem(double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker changes the hours worked on the activity from 8 to 5",
  "keyword": "When "
});
formatter.match({
  "location": "ActivitySteps.theDevelopmentWorkerChangesTheHoursWorkedOnTheActivityFromTo(Integer,Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker\u0027s hours on the activity is 5",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.theDevelopmentWorkerSHoursOnTheActivityIs(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases\\find_available_devs.feature");
formatter.feature({
  "name": "Project leader finds available developers for an activity",
  "description": "Description: Project leader gets a list of developers available for an activity\nActors: Project leader",
  "keyword": "Feature"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader gets a list of available developers",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the activity has a start date and end date",
  "keyword": "Given "
});
formatter.match({
  "location": "ActivitySteps.theActivityHasAStartDateAndEndDate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a development worker is available in the given timeperiod",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectOverviewSteps.aDevelopmentWorkerIsAvailableInTheGivenTimeperiod()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a development worker is not available in the given timeperiod",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectOverviewSteps.anotherDevelopemntWorkerIsNotAvailableInTheGivenTimeperiod()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader wants a list of available developers",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectOverviewSteps.theProjectLeaderWantsAListOfAvailableDevelopers()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader gets a list of developers, which contains the available development worker",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectOverviewSteps.theProjectLeaderGetsAListOfDevelopersWhichContainsTheAvailableDevelopmentWorker()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the list doesn\u0027t contain the unavailable developer",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectOverviewSteps.theListDoesnTContainTheUnavailableDeveloper()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader want available developers for an activity that doesnt\u0027t have a start date",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the activity doesn\u0027t has a start date",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectOverviewSteps.theActivityDoesnTHasAStartDate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader wants a list of available developers",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectOverviewSteps.theProjectLeaderWantsAListOfAvailableDevelopers()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Activity doesn\u0027t have a start/enddate\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader wants available developers for an activity that doesnt\u0027t have an end date",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the activity doesn\u0027t has a end date",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectOverviewSteps.theActivityDoesnTHasAEndDate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader wants a list of available developers",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectOverviewSteps.theProjectLeaderWantsAListOfAvailableDevelopers()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Activity doesn\u0027t have a start/enddate\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases\\generate_rappport.feature");
formatter.feature({
  "name": "Generate a rapport of a project",
  "description": "Beskrivelse: Project leader generates a project development rapport\nAktoer: Project leader",
  "keyword": "Feature"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader generates a project development rapport from a project of which she is project leader of",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the project leader generates a project development rapport of the project of which the project leader is the project leader of",
  "keyword": "When "
});
formatter.match({
  "location": "GenerateRapportSteps.theProjectLeaderGeneratesAProjectDevelopmentRapportOfTheProjectOfWhichTheProjectLeaderIsTheProjectLeaderOf()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development rapport is generated",
  "keyword": "Then "
});
formatter.match({
  "location": "GenerateRapportSteps.theGeneratedDevelopmentRapportIsGenerated()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Development worker attempts to generate a project development rapport",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker generates a project development rapport of a project",
  "keyword": "When "
});
formatter.match({
  "location": "GenerateRapportSteps.aDevelopmentWorkerGeneratesAProjectDevelopmentRapportOfAProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Action for project leader only\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases\\project_overview.feature");
formatter.feature({
  "name": "Project leader can get overview of time usage on project",
  "description": "\tDescription: A project leader creates a new project\n\tActor: Project leader",
  "keyword": "Feature"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a development worker is assigned the activity",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerIsAssignedTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker inputs 8 hours worked on the activity into the system",
  "keyword": "And "
});
formatter.match({
  "location": "RegisterTimeSteps.theDevelopmentWorkerInputsAmountOfHoursWorkedForTheDayIntoTheSystem(double)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader gets time spent on an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity2\"",
  "keyword": "Given "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a development worker inputs 4 hours worked on the activity with the name \"Activity2\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerInputsHoursWorkedOnTheActivityWithTheName(Integer,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader asks for time spent on the activity with the name \"Activity\"",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectOverviewSteps.theProjectLeaderAsksForTimeSpentOnTheActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader is told that 8 hours has been spent on the activity",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectOverviewSteps.theProjectLeaderIsToldThatHoursHasBeenSpentOnTheActivity(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a development worker is assigned the activity",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerIsAssignedTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker inputs 8 hours worked on the activity into the system",
  "keyword": "And "
});
formatter.match({
  "location": "RegisterTimeSteps.theDevelopmentWorkerInputsAmountOfHoursWorkedForTheDayIntoTheSystem(double)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader gets time spent on a project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the development worker inputs 4 hours worked on the activity into the system",
  "keyword": "Given "
});
formatter.match({
  "location": "RegisterTimeSteps.theDevelopmentWorkerInputsAmountOfHoursWorkedForTheDayIntoTheSystem(double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader asks for time spent on the project",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectOverviewSteps.theProjectLeaderAsksForTimeSpentOnTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader is told that 12 hours has been spent on the project",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectOverviewSteps.theProjectLeaderIsToldThatHoursHasBeenSpentOnTheProject(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a development worker is assigned the activity",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerIsAssignedTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker inputs 8 hours worked on the activity into the system",
  "keyword": "And "
});
formatter.match({
  "location": "RegisterTimeSteps.theDevelopmentWorkerInputsAmountOfHoursWorkedForTheDayIntoTheSystem(double)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader gets expected time left on a project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the bugettet time on the project is 12 hours",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.theBugettetTimeOnTheProjectIsHours(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader asks work remains on the project",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectOverviewSteps.theProjectLeaderAsksWorkRemainsOnTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader is told that 4 hours remain on the project",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectOverviewSteps.theProjectLeaderIsToldThatHoursRemainOnTheProject(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases\\put_developer_on_activity.feature");
formatter.feature({
  "name": "Manning of activities",
  "description": "Description: Add development workers to an activities\nActor: Project leader",
  "keyword": "Feature"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader adds a development worker to an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the project leader adds a development worker to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderAddsADevelopmentWorkerToAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker has been added to the activity",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.theDevelopmentWorkerHasBeenAddedToTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader adds a development worker, who is on 10 activities, who can work on 20 activities, to an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker has 10 activities",
  "keyword": "Given "
});
formatter.match({
  "location": "ActivitySteps.theDevelopmentWorkerHasActivities(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker can work on 20 activities",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theDevelopmentWorkerCanWorkOnActivities(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader adds a development worker to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderAddsADevelopmentWorkerToAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker has been added to the activity",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.theDevelopmentWorkerHasBeenAddedToTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader attempts to add a development worker, of which is already on 10 activities, to an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker has 10 activities",
  "keyword": "Given "
});
formatter.match({
  "location": "ActivitySteps.theDevelopmentWorkerHasActivities(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader adds a development worker to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderAddsADevelopmentWorkerToAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Selected development worker already assigned to 10 activities\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "A development worker attempts to add another developemnt worker to an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker assigns a new development worker to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerAssignsANewDevelopmentWorkerTheTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Action for project leader only\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project leader adds development worker to the activity, when the development worker has a private activity during the activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the activity has a start date and end date",
  "keyword": "Given "
});
formatter.match({
  "location": "ActivitySteps.theActivityHasAStartDateAndEndDate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a development worker registers the private activity \"Vacation\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theDevelopmentWorkerRegistersThePrivateActivity(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader adds a development worker to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderAddsADevelopmentWorkerToAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Private activity not allowed during work activity\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases\\register_time_on_activity.feature");
formatter.feature({
  "name": "Registering time on an activity",
  "description": "Description: Development workers register daily time used on an activity\nActor: Development worker",
  "keyword": "Feature"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "A development worker registers time spend on an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker is assigned the activity",
  "keyword": "Given "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerIsAssignedTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker inputs 8 hours worked on the activity into the system",
  "keyword": "When "
});
formatter.match({
  "location": "RegisterTimeSteps.theDevelopmentWorkerInputsAmountOfHoursWorkedForTheDayIntoTheSystem(double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker has worked 8 hours on the activity",
  "keyword": "Then "
});
formatter.match({
  "location": "RegisterTimeSteps.theSystemIsUpdatedWithTheGivenData(double)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Development worker registers time on an activity of which she is not part of or has helped with",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker is not assigned the activity",
  "keyword": "Given "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerIsNotAssignedTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker inputs 8 hours worked on the activity into the system",
  "keyword": "When "
});
formatter.match({
  "location": "RegisterTimeSteps.theDevelopmentWorkerInputsAmountOfHoursWorkedForTheDayIntoTheSystem(double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Specified user is not assigned to the activity\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Development worker registers time on an activity that doesn\u0027t excist",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker registers time on activity that doesn\u0027t excist",
  "keyword": "When "
});
formatter.match({
  "location": "RegisterTimeSteps.aDevelopmentWorkerRegistersTimeOnActivityThatDoesnTExcist()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Activity with specified name does not exist\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases\\register_time_on_helped_activity.feature");
formatter.feature({
  "name": "Register time on an activity of which a developemnt worker has helped another development worker with.",
  "description": "Description: Development workers can register time on an activity, which she is not part of, if another development worker is part of the activity and needs help\nActor: A development worker",
  "keyword": "Feature"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Register time on an activity of which a development worker has helped another development worker, which is part of the activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker is assigned the activity",
  "keyword": "Given "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerIsAssignedTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a different development worker is not assigned the activity",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.aDifferentDevelopmentWorkerIsAssignedTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the other worker inputs 8 hours to the activity together with the development workers initials",
  "keyword": "When "
});
formatter.match({
  "location": "RegisterTimeSteps.theWorkerInputsHelpingWorkhoursToTheActivityTogetherWithTheHelpedWorkersInitials(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the other worker has worked 8 hours on the activity",
  "keyword": "Then "
});
formatter.match({
  "location": "RegisterTimeSteps.theOtherWorkerHasWorked(double)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Register time on an activity of which a development worker has helped another development worker, which is NOT part of the project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker is not assigned the activity",
  "keyword": "Given "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerIsNotAssignedTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a different development worker is not assigned the activity",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.aDifferentDevelopmentWorkerIsAssignedTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the other worker inputs 8 hours to the activity together with the development workers initials",
  "keyword": "When "
});
formatter.match({
  "location": "RegisterTimeSteps.theWorkerInputsHelpingWorkhoursToTheActivityTogetherWithTheHelpedWorkersInitials(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Specified user is not assigned to the activity\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases\\register_time_on_private_activity.feature");
formatter.feature({
  "name": "Register time on private activity",
  "description": "Description: A development worker can register things like holidays, sickness and courses\nActor: A development worker",
  "keyword": "Feature"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "A development worker registers time on a private",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker registers the private activity \"Vacation\"",
  "keyword": "When "
});
formatter.match({
  "location": "ActivitySteps.theDevelopmentWorkerRegistersThePrivateActivity(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the delopment worker has a private activity \"Vacation\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.theDelopmentWorkerHasAPrivateActivity(String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "A development worker registers time on a private activity, when the development worker is assigned an activity in the time frame",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker is assigned the activity",
  "keyword": "Given "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerIsAssignedTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity has a start date and end date",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theActivityHasAStartDateAndEndDate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a development worker registers the private activity \"Vacation\"",
  "keyword": "When "
});
formatter.match({
  "location": "ActivitySteps.theDevelopmentWorkerRegistersThePrivateActivity(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Private activity not allowed during work activity\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases\\select_project_leader.feature");
formatter.feature({
  "name": "Choosing a project leader",
  "description": "\tDescription: A project leader is chosen for a project\n\tActors: A development worker",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Assign project leader",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project doesn\u0027t have a project leader",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.theProjectDoesnTHaveAProjectLeader()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a developement worker is assigned to be the project leader",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectSteps.aDevelopementWorkerIsAssignedToBeTheProjectLeader()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader of the project is the development worker",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.theProjectLeaderOfTheProjectIsTheDevelopmentWorker()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Assign new project leader",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader assigns a development worker to be project leader",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectSteps.theProjectLeaderThatCreatedTheProjectAssignsADevelopmentWorkerToBeProjectLeader()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the selected development worker is made leader of the project",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.theSelectedDevelopmentWorkerIsMadeLeaderOfTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Development worker assigns project leader for a project they are not the leader of",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a development worker is not the leader of the project",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aDevelopmentWorkerIsNotTheLeaderOfTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker assigns a development worker to be project leader",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectSteps.theDevelopmentWorkerThatCreatedTheProjectAssignsADevelopmentWorkerToBeProjectLeader()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an error message \"Action for project leader only\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases\\worker_work_overview.feature");
formatter.feature({
  "name": "Development worker gets hours worked on the day",
  "description": "Description: Worker gets total amount of hours worked on the day\nActors: Development worker",
  "keyword": "Feature"
});
formatter.background({
  "name": "A project and an activity exists",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a project with the name \"Project 1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a development worker is assigned the activity",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerIsAssignedTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Worker gets the amount of hours he has worked on the day",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the development worker inputs 8 hours worked on the activity into the system",
  "keyword": "Given "
});
formatter.match({
  "location": "RegisterTimeSteps.theDevelopmentWorkerInputsAmountOfHoursWorkedForTheDayIntoTheSystem(double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker the next day inputs 5 hours worked on the activity into the system",
  "keyword": "And "
});
formatter.match({
  "location": "RegisterTimeSteps.theDevelopmentWorkerTheNextDayInputsHoursWorkedOnTheActivityIntoTheSystem(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker wants to know how many hours he has worked on the day",
  "keyword": "When "
});
formatter.match({
  "location": "RegisterTimeSteps.theDevelopmentWorkerWantsToKnowHowManyHoursHeHasWorkedOnTheDay()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the development worker is told that he has worked 5 hours on the day",
  "keyword": "Then "
});
formatter.match({
  "location": "RegisterTimeSteps.theDevelopmentWorkerIsToldThatHeHasWorkedHoursOnTheDay(Integer)"
});
formatter.result({
  "status": "passed"
});
});