import sqlite3

def readSql():
    f=open('data.sql','r')
    temp=f.read()
    query=[]
    for x in temp.split(";"):
        query.append(x)
    return query

if __name__ == '__main__':
    db_name = 'data'
    conn = sqlite3.connect('{}.db'.format(db_name))
    db = conn.cursor()
    query=readSql()
    for sql in query:
        db.execute(sql)
