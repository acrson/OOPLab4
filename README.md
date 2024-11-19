- Name the two patterns you wish to implement and explain what advantages you hope to achieve with them:

The two patterns I will be implementing are the Observer and Mediator patterns.

Observer Pattern:
TablePanel will be the subject because it notifies the observers when a change occurs, in this example, a new row or column being selected on the table. The DetailsPanel and StatsPanel would be the observers in this example because they "observe" the changes from the subject and react to them accordingly.

Mediator Pattern:
A mediator class will be implemented, managing the interactions between TablePanel, DetailsPanel, and StatsPanel. This keeps them from referring to each other explicitly and allows mediator to be the "hub" that controls the interactions between each of them. If the code is to expanded upon or updated in the future, this ensures that no issues will arise from their current dependencies.


These design patterns will help make the code easier to navigate and manage by making the classes more modulular and less dependent on each other.


- Describe how you implement the patterns, including additional interfaces, classes, and how these will integrate with the classes that you already have:
Will be updated as I work on this lab. 
