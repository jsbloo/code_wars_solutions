const doneOrNot = (board) => {
    const numObj = {
        1:'',
        2:'',
        3:'',
        4:'',
        5:'',
        6:'',
        7:'',
        8:'',
        9:''
    };

    let rows = new numObj();
    let cols = new numObj();

    let incr = 0;

    for(const i of board){
        cols[incr] = i[0];
        incr +=1;
        let incr2 = 0;
        for(const j of i){
            rows[incr2] = j;
            incr2+=1;
        }
    }
}