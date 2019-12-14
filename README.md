# Premiere League
Sample Project Task Fetching data from this Endpoint : https://api.football-data.org/v2/competitions/2021/matches 

# Technologies Used 
- Used <b> RxJava </b> to fetch data in a Specifed Thread and pass value response to MutableLive Data to be observed .
with <b> Map operator </b> to make changes on the data stream recieved 
- Used <b> Retrofit </b> as Network Client with <b>Gson</b> for Json Serialization.  
- Used <b> Android Architecture  MVVM </b>
- Used <b> Kotlin Collections as Filter And Group By for received Data </b>   
- Used <b> Room Database from Jetpack Component </b> to Save Favourite Matches in Database and retrieve it in Favourites Tab
- Used <b> Koin </b>as Dependency injection from <b> Repository </b> ,<b> Network </b>,<b> Database </b>,<b> Data Source </b> layers.  
- Used <b> Pandora Bottom Navigation Library </b> to handle Multiple BackStacks ("Not best thing to implement ")
- Used <b> Groupie Adapter for it's own ready adapter , expandable tree recycler library for expandble list effect </b> to  show data as expandable 


## Upcoming 
- Unit test with Mocck Framework
- handle errors if no network , or server error
- handle save state of favourite icon
- ui enhancments as show time with AM and PM , change date to be as Days (Today,Tomorrow ,.. )
