The two patterns I will be implementing are the Observer and Mediator patterns.

Observer Pattern:
TablePanel will be the subject because it notifies the observers when a change occurs, in this example, a new row or column being selected on the table. The DetailsPanel and StatsPanel would be the observers in this example because they "observe" the changes from the subject and react to them accordingly.

Mediator Pattern:
A mediator class will be implemented, managing the interactions between TablePanel, DetailsPanel, and StatsPanel. This keeps them from referring to each other explicitly and allows mediator to be the "hub" that controls the interactions between each of them. If the code is to expanded upon or updated in the future, this ensures that no issues will arise from their current dependencies.

These design patterns will help make the code easier to navigate and manage by making the classes more modulular and less dependent on each other.

In order to manage communication between the TablePanel, DetailsPanel, and FilterPanel and make sure these classes stayed independent of each other, I integrated the Mediator design pattern as the Mediator class. The Mediator serves as a central hub with tools for updating details and (if the filter panel were to work) applying filters. The panels were easily connected because of this structure. To implement the Observer pattern, I made DetailsPanel and StatsPanel observers of subject TablePanel. Whenever a row is selected in TablePanel, it notifies the Mediator, which updates the observers with correct data. DetailsPanel displays additional information about the selected row, and StatsPanel updates its statistics dynamically. The Observer pattern ensures that the panels are always in sync with the selection in TablePanel without being too dependent on each other.
