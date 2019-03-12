# UWinfos
Android App for UW Info Session

-UWinfos v1.0-

Main functions: 
-Request from UW-API for Info Session information. Display on an Android App.
 
Application Structure:
![Blueprint](/display/Blueprint.PNG)

Data:
- HTTP Request Java (Request every time User open the app ¨C check network and request)
- How to store data (Internal JsonObject or SQLite?)

UI:
- MainActivity: Info Session Blocks (Sorted by Time: now -> future)
	o Scroll down
	o Click ¨C(Info Block)> DetailActivity
	o Enter twice to exit
- DetailActivity: Info Session Details 
	o Scroll down
	o Click ¨C(Website & Register Link <Hyperlink>)> WebsiteActivity
	o Enter once to return to the MainActivity page
- WebsiteActivity(?): Browse website (Internal or External?)
	o Do what web can do
