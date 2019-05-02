$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("use_cases\\create_activity.feature");
formatter.feature({
  "name": "Oprettelse af aktivitet",
  "description": "\tBeskrivelse: En projektleder opretter en aktivitet\n\tAktoer: Projektleder",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Opret en aktivitet",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a new activity with the name \"Activity\" is created",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Opret en aktivitet uden at vaere projektleder",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a development worker creates an activity for the project",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an error message \"Only project leaders can create activities\" is presented",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Opret aktivitet med sluttidspunkt foer starttidspunkt",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project has been created",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project leader creates a new activity with the name \"Activity\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project leader assigns a start date",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project leader assigns a deadline that is before the assigned start date",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an error message \"Deadline cannot be before the assigned start date\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("use_cases\\create_project.feature");
formatter.feature({
  "name": "Creating project",
  "description": "\tDescription: Testing project creation\n\tActors: Development worker",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Opret et projekt",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker is registered in the system",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a development worker creates a new project with the name \"New Project\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a new project is created with the name \"New Project\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project is given a unique number for identification.",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Opret et projekt med samme navn som et andet projekt",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project with the name \"Project 1\" already exists",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a development worker tries to create a new project with the same name",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an error message \"Project with given name already exists\" is presented",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Opret et projekt med starttidspunkt foer projektoprettelsen",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a development worker creates a new project",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project leader assigns a start date for the project that is before the project creation date",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "an error message \"Project start date cannot be before the project creation date\" is presented",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("use_cases\\select_project_leader.feature");
formatter.feature({
  "name": "Valg af projektleder",
  "description": "\tDescription: En projektleder vaelges til et projekt\n\tActors: Udviklingsmedarbejder",
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
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a project leader has been selected",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
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