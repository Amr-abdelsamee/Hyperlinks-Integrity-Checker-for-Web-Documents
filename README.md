# Hyperlinks-Integrity-Checker-for-Web-Documents


## Content:
- [Over view](#Over-view)
- [Program Screenshots](#Program-Screenshots)
  - [Main Window](#Main-Window)
  - [Loading Window](#Loading-Window)
  - [Results Window](#Results-Window)
- [Author](#Author)


## Over-view
 Hyperlinks Checker program is a program the get inside the HTML document of the provided link and search for the links in the <"a"> tag and check if these links work or not. A report is provided at the end of this process.
 The program uses multi-threads to finish the check faster as some HTML documents contain thousands of links.
 Also, the user can specify how deep this process should go by changing the depth value starting from 0. Depth 1 means check the links in the HTML of the provided link and the links inside these links, this can go so deep and take so long time by increasing the depth.
 Flexibility exist in the program as The program checks the machine maximum threads that can be used so the user can choose the number of threads to do the process but within the range of the machine threads.


## Program-Screenshots

### Main-Window

<img src="https://github.com/Amr-abdelsamee/Hyperlinks-Integrity-Checker-for-Web-Documents/blob/main/screenshots/main-window.png" alt="Main-menu"/>

### Loading-Window

<img src="https://github.com/Amr-abdelsamee/Hyperlinks-Integrity-Checker-for-Web-Documents/blob/main/screenshots/loading-window.png" alt="Loading window"/>

### Results-Window
#### depth is 0

<img src="https://github.com/Amr-abdelsamee/Hyperlinks-Integrity-Checker-for-Web-Documents/blob/main/screenshots/results-depth-0.png" alt="results-depth-0"/>

#### depth is 1

<img src="https://github.com/Amr-abdelsamee/Hyperlinks-Integrity-Checker-for-Web-Documents/blob/main/screenshots/results-depth-1.png" alt="results-depth-1"/>
