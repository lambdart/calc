
# Table of Contents

1.  [Introduction](#orgb57715b)
2.  [Version](#org499becd)
3.  [Dependencies](#org144a3a2)
4.  [Tested on](#org8e79ce6)
5.  [Installation](#org34404d3)
6.  [Configuration](#orgc99fe21)
7.  [Testing](#orgcf77073)
    1.  [The Frontend](#org067ddb1)
    2.  [The API server](#org1061c30)
8.  [LICENSE](#orge6fd8c3)
9.  [References](#orgeea2289)
10. [EOF](#org0b76339)



<a id="orgb57715b"></a>

# Introduction

An simple full stack application.


<a id="org499becd"></a>

# Version

Alpha - 0.0.1


<a id="org144a3a2"></a>

# Dependencies

All the dependencies are described on the `deps.edn` file, check it out :)


<a id="org8e79ce6"></a>

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


<a id="org34404d3"></a>

# Installation

The simplest way is to build the docker image and run the container, the
auto.sh scripts will help you on that, just use the commands below:

    
    ./scripts/auto.sh -s calc build
    ./scripts/auto.sh -s nginx build
    ./scripts/auto.sh setup
    ./scripts/auto.sh start


<a id="orgc99fe21"></a>

# Configuration

The configuration file can be found at the `resources/dev`,
`resources/prod` and `resources/test`. The default behaviour is to load the
`resources/dev/config.edn` edn and docker containers will be load with
`resources/dev/config-docker.edn`.

See the `deps.edn` file for more information on how to invoke Clojure with
arbitrary configuration file.


<a id="orgcf77073"></a>

# Testing


<a id="org067ddb1"></a>

## The Frontend

It's use the Firefox and point the URL to `http://localhost:3000`.
Select one operation and click in the button run, if everything works
properly the results will appear at the bottom of the form.


<a id="org1061c30"></a>

## The API server

It's possible to use curl or any http client of choice to access the API.
In case you are running this at your local host and the curl command is
installed, just type the following commands at the terminal emulator of use:

    
    curl "http://localhost:8080/v1/increment"
    curl "http://localhost:8080/v1/reset"


<a id="orge6fd8c3"></a>

# LICENSE

MIT


<a id="orgeea2289"></a>

# References

1.  <https://clojuredocs.org>
2.  <https://clojurescript.org/guides>
3.  <http://pedestal.io/reference/interceptors>
4.  <https://github.com/day8/re-frame>
5.  <https://day8.github.io/re-frame/re-frame>
6.  <https://docs.datomic.com/datomic-overview.html>


<a id="org0b76339"></a>

# EOF

