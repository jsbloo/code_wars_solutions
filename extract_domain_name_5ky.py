#[5kyu]Extract the domain name from a URL
#
# Write a function that when given a URL as a string, 
# parses out just the domain name and returns it as a string.
#For example: domain_name("http://github.com/carbonfive/raygun") == "github" 
import re 
def domain_name(url):
    result = re.search('www.(.*?)\.', url)

    if result:
        return result.group(1)

    result2 = re.search('\//(.*?)\.', url)
    if result2:
        return result2.group(1)

    result3 = re.search('(.*?)\.', url)
    if result3:
        return result3.group(1)

