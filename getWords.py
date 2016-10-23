from bs4 import BeautifulSoup
import requests





i = 1
text_file = open("output.csv", "w")

url_id = 1

while url_id < 11:
    if(url_id < 10):
        temp =  "0" + str(url_id)
    else:
        temp = str(url_id)

    r = requests.get('http://www.majortests.com/gre/wordlist_'+temp)
    url_id = url_id + 1
    html =  r.text
    soup = BeautifulSoup(html, 'html.parser')
    for pair in soup.find_all('tr'):

        line = str(i) + "," + pair.th.text + "," + pair.td.text.replace(',', ';') + ",0" +"\n"
        text_file.write(line.encode('ascii', 'ignore').decode('ascii'))
        i = i+1

text_file.close()
