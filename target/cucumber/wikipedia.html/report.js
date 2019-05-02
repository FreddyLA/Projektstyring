$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("use_cases\\change_activity.feature");
formatter.feature({
  "name": "Change activity",
  "description": "Description: A project leader edits activies\nActor: Project leader",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Project leader edits an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\change_activity.feature:6)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project leader edits activity",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderEditsActivity()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the activity is changed",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.theActivityIsChanged()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "A development worker edits an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\change_activity.feature:13)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "a development worker attempts to edit an activity",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerAttemptsToEditAnActivity()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "an error message \"Only project leader is allowed to edit activities\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "The project leader changes the deadline to be before the start time",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\change_activity.feature:20)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("use_cases\\create_activity.feature");
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
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\create_activity.feature:6)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "a new activity with the name \"Activity\" is created",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.aNewActivityWithTheNameIsCreated(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Creating an activity without being project leader",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\create_activity.feature:12)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "a development worker creates an activity for the project",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.aDevelopmentWorkerCreatesAnActivityForTheProject()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "an error message \"Only project leaders can create activities\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Create an activity with deadline before start time",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\create_activity.feature:17)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project leader assigns a start date to the activity",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderAssignsAStartDateToTheActivity()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project leader assigns a deadline to the activity that is before the assigned start date",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderAssignsADeadlineToTheActivityThatIsBeforeTheAssignedStartDate()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "an error message \"Deadline cannot be before the assigned start date\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "skipped"
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
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aDevelopmentWorkerIsRegisteredInTheSystem(ProjectSteps.java:24)\r\n\tat ✽.a development worker is registered in the system(use_cases\\create_project.feature:6)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "a development worker creates a new project with the name \"New Project\"",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectSteps.aDevelopmentWorkerCreatesANewProjectWithTheName(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "a new project is created with the name \"New Project\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectSteps.aNewProjectIsCreatedWithTheName(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project is given a unique number for identification.",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.theProjectIsGivenAUniqueNumberForIdentification()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Create a project with the same name as a another project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project with the name \"Project 1\" already exists",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectWithTheNameAlreadyExists(String)"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectWithTheNameAlreadyExists(ProjectSteps.java:48)\r\n\tat ✽.a project with the name \"Project 1\" already exists(use_cases\\create_project.feature:12)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "a development worker tries to create a new project with the same name",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aDevelopmentWorkerTriesToCreateANewProjectWithTheSameName()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "an error message \"Project with given name already exists\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Create a project with start time before project creation time",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker creates a new project",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aDevelopmentWorkerCreatesANewProject()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aDevelopmentWorkerCreatesANewProject(ProjectSteps.java:60)\r\n\tat ✽.a development worker creates a new project(use_cases\\create_project.feature:17)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project leader assigns a start date for the project that is before the project creation date",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.theProjectLeaderAssignsAStartDateForTheProjectThatIsBeforeTheProjectCreationDate()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "an error message \"Project start date cannot be before the project creation date\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("use_cases\\edit_registered_data.feature");
formatter.feature({
  "name": "Edit previously registered data",
  "description": "Description: Development worker edits previously registered time on an activity\nActor: Development worker",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Editing previously registred time on an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\edit_registered_data.feature:6)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the project has an activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a development worker is assigned the activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the development worker inputs amount of hours worked for the day into the system",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the development worker edits previously added amount of work hours",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("use_cases\\generate_rappport.feature");
formatter.feature({
  "name": "Generate a rapport of a project",
  "description": "Beskrivelse: Project leader generates a project development rapport\nAktoer: Project leader",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Project leader generates a project development rapport from a project of which she is project leader of",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\generate_rappport.feature:6)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the project has been worked on",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project leader generates a project development rapport of the project of which the project leader is the project leader of",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the generated development rapport is generated",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Project leader attempts to generate a project development rapport from a project she is not project leader of",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\generate_rappport.feature:12)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the project has been worked on",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project leader generates a project development rapport of the project of which the project leader is not the project leader of",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an error message \"Only the project leader of the project can generate a development rapport of the project\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Development worker attempts to generate a project development rapport",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\generate_rappport.feature:18)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the project has been worked on",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a development worker generates a project development rapport of a project",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an error message \"Only the project leader of the project can generate a development rapport of the project\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("use_cases\\man_activity.feature");
formatter.feature({
  "name": "Manning of activities",
  "description": "Description: Add development workers to an activities\nActor: Project leader",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Project leader adds a development worker to an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\man_activity.feature:6)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project leader adds a development worker to an activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the development worker has been added to the activity",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Project leader attempts to add a development worker, of which is already on 10 activities, to an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\man_activity.feature:13)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({
  "location": "ActivitySteps.theProjectLeaderCreatesANewActivityWithTheName(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the project leader adds a development worker to an activity which is already assigned 10 activities",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an error message \"Selected development worker already assigned to 10 activities\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "A development worker attempts to add another developemnt worker to an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\man_activity.feature:20)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the project has an activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a development worker is assigned the activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a development worker assigns a new development worker the the activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an error message \"Only project leader can add workers to activity\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("use_cases\\project_overview.feature");
formatter.feature({
  "name": "Overview of a project",
  "description": "Description: The projectleader views the statistics of each activity of a project and of total project\nActor: Project leader",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Project leader views project overview",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\project_overview.feature:6)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the project has activities",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the activities of the project has registrered workhours from assigned development workers",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project leader access an overview of the project development",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an overview of the project development is presented",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "A development worker attempts to view project overview",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\project_overview.feature:13)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the project has activities",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the activities of the project has registrered workhours from assigned development workers",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a development worker access an overview of the project development",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an error message \"Only project leaders can see an overview of the project development\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("use_cases\\register_time_on_activity.feature");
formatter.feature({
  "name": "Registering time on an activity",
  "description": "Description: Development workers register daily time used on an activity\nActor: Development worker",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "A development worker registers time spend on an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\register_time_on_activity.feature:6)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the project has an activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a development worker is assigned the activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the development worker inputs amount of hours worked for the day into the system",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the system is updated with the given data",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Development worker registers time on an activity of which she is not part of or has helped with",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\register_time_on_activity.feature:13)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the project has an activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a development worker is not assigned the activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the development worker inputs amount of hours worked for the day into the system",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an error message \"Specified user is not assigned to the activity\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("use_cases\\register_time_on_helped_activity.feature");
formatter.feature({
  "name": "Register time on an activity of which a developemnt worker has helped another development worker with.",
  "description": "Description: Development workers can register time on an activity, which she is not part of, if another development worker is part of the activity and needs help\nActor: A development worker",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Register time on an activity of which a development worker has helped another development worker, which is part of the activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\register_time_on_helped_activity.feature:6)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the project has an activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a development worker is not assigned the activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a different development worker is assigned the activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the worker inputs helping workhours to the activity together with the helped workers initials",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the system is updated with the given data",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Register time on an activity of which a development worker has helped another development worker, which is NOT part of the project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\register_time_on_helped_activity.feature:14)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the project has an activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a development worker is not assigned the activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a different development worker is not assigned the activity either",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the worker inputs helping workhours to the activity together with the helped workers initials",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an error message \"Helped co-worker is not assigned to the specified activity\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("use_cases\\register_time_on_personal_schedule.feature");
formatter.feature({
  "name": "Register time on personal schedule",
  "description": "Description: A development worker can register things like holidays, sickness and courses\nActor: A development worker",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "A development worker registers time on personal schedule",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker inputs firm activity in his schedule",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the system is updated with development workers registered firm activity",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the development worker cannot be added to an activity in the registered time frame",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "A project leader attempts to add a development worker on an activity inside a timeframe that the developemnt worker already has registered personal time on her schedule",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker inputs firm activity in his schedule",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a project leader assigns the development worker to an activity during the firm activity timeframe",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an error message \"Development worker is not available for work on the activity\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("use_cases\\select_project_leader.feature");
formatter.feature({
  "name": "Choosing a project leader",
  "description": "\tDescription: A project leader is chosen for a project\n\tActors: A development worker",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Choosing project leader",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\select_project_leader.feature:6)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the development worker that created the project assigns a development worker to be project leader",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the selected development worker is made leader of the project",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Choosing projectleader for a project that already has a project leader",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\select_project_leader.feature:11)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectSteps.aProjectLeaderHasBeenSelected()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the development worker that created the project assigns a development worker to be project leader",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an error message \"Project leader already assigned\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Choose a project leader which is already a project leader",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({
  "location": "ProjectSteps.aProjectHasBeenCreated()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat dtu.projektstyring.acceptance_tests.ProjectSteps.aProjectHasBeenCreated(ProjectSteps.java:12)\r\n\tat ✽.a project has been created(use_cases\\select_project_leader.feature:17)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the development worker that created the project assigns a development worker to be project leader",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the selected development worker already is a project leader for another project",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an error message \"Selected person already project leader for another project\" is presented",
  "keyword": "Then "
});
formatter.match({
  "location": "ActivitySteps.anErrorMessageIsPresented(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("use_cases\\test.feature");
formatter.feature({
  "name": "Cucumber test",
  "description": "\tDescription: Test that cucumber works\n\tActors: me",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Test",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that cucumber works",
  "keyword": "Given "
});
formatter.match({
  "location": "CucumberTest.that_cucumber_works()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "cucumber works",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberTest.cucumber_works()"
});
formatter.result({
  "status": "passed"
});
});