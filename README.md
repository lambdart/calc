
# Table of Contents

1.  [Introduction](#org5eb875f)
2.  [Version](#org1c31707)
3.  [Dependencies](#orga45572d)
4.  [Tested on](#org67936ad)
5.  [Installation](#org87213e0)
6.  [Configuration](#orgb1328c5)
7.  [Testing](#org47384cc)
    1.  [The Frontend](#org1121df7)
    2.  [The API server](#orgfd8bd04)
8.  [LICENSE](#orge0db200)
9.  [EOF](#org933140d)



<a id="org5eb875f"></a>

# Introduction

An simple full stack application.


<a id="org1c31707"></a>

# Version

Alpha - 0.0.1


<a id="orga45572d"></a>

# Dependencies

All the dependencies are described on the `deps.edn` file, check it out :)


<a id="org67936ad"></a>

# Tested on

<table border="2" cellspacing="0" cellpadding="6" rules="groups" frame="hsides">


<colgroup>
<col  class="org-left" />

<col  class="org-right" />
</colgroup>
<tbody>
<tr>
<td class="org-left">OS</td>
<td class="org-right">Version</td>
</tr>

<tr>
<td class="org-left">FreeBSD</td>
<td class="org-right">14.2</td>
</tr>

<tr>
<td class="org-left">Alpine</td>
<td class="org-right">3.23</td>
</tr>

<tr>
<td class="org-left">Docker</td>
<td class="org-right">28.2.2</td>
</tr>

<tr>
<td class="org-left">Firefox</td>
<td class="org-right">139.0.4</td>
</tr>
</tbody>
</table>


<a id="org87213e0"></a>

# Installation

The simplest way is to build the docker image and run the container, the
auto.sh scripts will help you on that, just use the commands below:

    
    ./scripts/auto.sh -s calc build
    ./scripts/auto.sh -s nginx build
    ./scripts/auto.sh setup
    ./scripts/auto.sh start


<a id="orgb1328c5"></a>

# Configuration


<a id="org47384cc"></a>

# Testing


<a id="org1121df7"></a>

## The Frontend

It's use the Firefox and point the URL to `http://localhost:3000`.
Select one operation and click in the button run, if everything works
properly the results will appear at the bottom of the form.


<a id="orgfd8bd04"></a>

## The API server

It's possible to use curl or any http client of choice to access the API.
In case you are running this at your local host and the curl command is
installed, just type the following commands at the terminal emulator of use:

    
    curl "http://localhost:8080/v1/increment"
    curl "http://localhost:8080/v1/reset"


<a id="orge0db200"></a>

# LICENSE

MIT


<a id="org933140d"></a>

# EOF

