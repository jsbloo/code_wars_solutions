const parse = (data) => {
  
    let value = 0;
    let arr = [];

    for (const e of data){
        switch(e){
            case 'i':
                value+=1;
                break;
            case 'd':
                value-=1;
                break;
            case 's':
                value = Math.pow(value, 2);
                break;
            case 'o':
                arr.push(value);
                break;
        }
    }

    return arr;
  }


