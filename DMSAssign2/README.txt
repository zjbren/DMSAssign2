DMS ASSIGN 2 README
ZACH BRENNAN 16941261

Design notes

index.jsp
Main page, has links to either login or register as user on the respective JSP. All pages show current active user at bottom of page as managed by session data

login.jsp
Contains login form managed through the loginprocess.java servlet which confirms that input matches the required format and the user exists by access userbean to run sql on the database. Of note there is no password validation currently.

register.jsp
Allows a new user to be registered by passing the inputed data through longprocess.java to the userbean which checks the user doesn't already exist and then adds it to the database and logs them in.

home.jsp
Homepage for logged in users. Displays active username and has links to post or search for a post

post.jsp
allows a user to post a status to the db through postprocess.java and the postbean

searchPost.jsp
allows a user to search posts by status_code in the database through searchprocess.java and the postbean.

logoutprocess.java
Each page allows the user to logout. This servlet manages session data to change the active user to null

Installation
Load project into netbeans, ensure glassfish is active and works. Create JDBC DB named ZACHBOOKDB with two tables:

USERS (userName(varchar(8)), pwd(varchar(15), email(varchar(25))
POST (status_code(varchar(5), status(varchar(250))

Once this is inplace, deploy the Java EE application to glassfish and run