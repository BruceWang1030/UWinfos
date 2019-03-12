# UWinfos
Android App for UW Info Session

-UWinfos v1.0-

Main functions: 
-Request from UW-API for Info Session information. Display on an Android App.
 
Application Structure:
![Blueprint](/display/Blueprint.PNG)

Data:
- HTTP Request Java (Request every time User open the app -- check network and request)
- How to store data (Internal JsonObject or SQLite?)

UI:
- MainActivity: Info Session Blocks (Sorted by Time: now -> future)
	* Scroll down
	* Click -(Info Block)> DetailActivity
	* Enter twice to exit
- DetailActivity: Info Session Details 
	* Scroll down
	* Click -(Website & Register Link <Hyperlink>)> WebsiteActivity
	* Enter once to return to the MainActivity page
- WebsiteActivity(?): Browse website (Internal or External?)
<<<<<<< HEAD
	o Do what web can do

Progress:

March 11, 2019 <Data - Http Request>
* Set up blueprint
* Tried Http Request Library: Unirest
* Tried Java Json Library: Gson
* Http Request: currently doesn't work 
=======
	* Do what web can do
>>>>>>> 58df4901d941213322e7536c67914ea29d254bc5
