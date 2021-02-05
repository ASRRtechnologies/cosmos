# Cosmos 
## ASRR Kotlin Playground
<img src ="https://img.shields.io/badge/Powered%20By-ASRR-black?style=for-the-badge"/>

[![codebeat badge](https://codebeat.co/badges/bd8fbf4e-9368-471c-aef7-7f7f1fe956ae)](https://codebeat.co/projects/github-com-asrrtechnologies-cosmos-main)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/8ea97b6909f04c76b884a619fd7f8c12)](https://www.codacy.com/gh/ASRRtechnologies/cosmos/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ASRRtechnologies/cosmos&amp;utm_campaign=Badge_Grade)



Repository that houses the element database, powering the Project Configurator with over 30k elements. Built on Spring Boot.


<img src="https://img.shields.io/badge/spring-boot%20-%236DB33F.svg?&style=for-the-badge&logo=spring&logoColor=white"/> <img src="https://img.shields.io/badge/kotlin-%230095D5.svg?&style=for-the-badge&logo=kotlin&logoColor=white"/> <img src ="https://img.shields.io/badge/MongoDB-%234ea94b.svg?&style=for-the-badge&logo=mongodb&logoColor=white"/>
<img src="https://img.shields.io/badge/gradle%20-%2302313A.svg?&style=for-the-badge&logo=gradle&logoColor=white"/> 

## Development Rules:
- `JavaDoc` summary tags in all public functions
- Add Swagger documentation for all API calls
- Start your branch name with the Jira Issue name, e.g.: `VWPC-123/fix-this-issue`
- Use clear commit messages, and commits should contain only one action. Formulate commit messages as if you try to complete the following sentence: `This commit will allow me to ...`

### Code style
- Make sure checkstyle check (found in repo root) passes.
- Avoid code nesting
- Use `Lombok` for data types  
- Run PMD for more tips

### Resources
- JIRA board https://asrrtechnologies.atlassian.net/jira/software/projects/VWPC/boards/2
- Confluence Documentation & Briefing https://asrrtechnologies.atlassian.net/wiki/spaces/VP/overview

| Name   | Url        |   
| :------------- |-------------:|
| <img src="https://img.shields.io/badge/Jira%20-%230352CC.svg?&style=for-the-badge&logo=jira&logoColor=white"/>    | https://asrrtechnologies.atlassian.net/jira/software/projects/VWPC/boards/2 |  
| <img src="https://img.shields.io/badge/Confluence%20-%230352CC.svg?&style=for-the-badge&logo=confluence&logoColor=white"/>       | https://asrrtechnologies.atlassian.net/wiki/spaces/VP/overview      |  



## Environments
### Acceptatie 
| Name   | Status        |   
| :------------- |-------------:| 
| <img src="https://img.shields.io/badge/swagger%20-%2343853D.svg?&style=for-the-badge&logo=swagger&logoColor=white"/>    | https://acceptatie.element-db.vw.api.asrr-tech.com/api/v1/docs |  
| <img src="https://img.shields.io/badge/Travis CI%20-%23000000.svg?&style=for-the-badge&logo=travis&logoColor=white"/>   | [![Build Status](https://travis-ci.com/ASRRtechnologies/vw-element-db.svg?token=qupxX6pFHqDaPdjEFnQm&branch=acceptatie)](https://travis-ci.com/ASRRtechnologies/vw-asrr-element-db)      |  

### Productie 
| Name   | Status        |   
| :------------- |-------------:| 
| <img src="https://img.shields.io/badge/swagger%20-%2343853D.svg?&style=for-the-badge&logo=swagger&logoColor=white"/>      | https://productie.element-db.vw.api.asrr-tech.com/api/v1/docs |  
| <img src="https://img.shields.io/badge/Travis CI%20-%23000000.svg?&style=for-the-badge&logo=travis&logoColor=white"/>      | [![Build Status](https://travis-ci.com/ASRRtechnologies/vw-element-db.svg?token=qupxX6pFHqDaPdjEFnQm&branch=productie)](https://travis-ci.com/ASRRtechnologies/vw-asrr-element-db)     |  


