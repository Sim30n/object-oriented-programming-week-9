# object-oriented-programming-week-9
9.1. Create a graphical user interface where it is possible to list all Finnkino theaters in a drop-down list. User can choose a theater from the list and afterwards the application lists movies shown in that specific theater. You don't have to implement the functionalities yet, more important is to get the components in place. There should be different search criteria like date, time, name of the movie and place.

9.2. Try using the Finnkino XML service through a web browser (clicking the links or modifying the url) at https://www.finnkino.fi/xml/. Create software that makes it possible to read XML files that handles Theaters (areas XML). Create a class that stores the information of all Theaters.

You will need a class that stores Theaters in a data structure, another class that has the Theater information (location and ID). Integrate this software to your graphical user interface so that sets the Theaters to the drop-down list and user can choose a Theater from the list.

9.3. Start searching for movies in a specific theater by current date. You will need current date and the theater ID. With these, the URL should be in a following form:

http://www.finnkino.fi/xml/Schedule/?area=<theaterID>&dt=<date in dd.MM.yyyy format>     
<- and >-character do not belong to the URL, they represent the parameters!

Parse the movie information every time a theater has been chosen and a user wants to see results. You should use a list component to present the results (e.g. RecyclerView, ScrollView, ListView or something else) that lists every result in their own row. Like in the previous exercise, user interface only presents information but it does not contain any information to parsing or storing data. Temporary data structures are allowed if necessary.

9.4. Add a functionality where a user can input date and time interval that are used to search for movies. Date directly affects the data you are searching for and time interval affects what will finally be shown. So create fields for date input and time interval input (start after, start before). If all fields are left empty, show all movies that run in the selected theater on that date.

9.5. Make a search functionality that searches all theaters for movies with the name. The application should show the results so that it shows the name of the movie, place and time it is shown. The search functionality should work together with the earlier search functionalities AND if no theater is given, it will search through all theaters. Note: There are 9 different areas for theaters if you exclude the more specific ones. ID 1029 does not show all.
