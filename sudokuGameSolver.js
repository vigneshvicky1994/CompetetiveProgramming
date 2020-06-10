var board = [
    [3, 0, 6, 5, 0, 8, 4, 0, 0],
    [5, 2, 0, 0, 0, 0, 0, 0, 0],
    [0, 8, 7, 0, 0, 0, 0, 3, 1],
    [0, 0, 3, 0, 1, 0, 0, 8, 0],
    [9, 0, 0, 8, 6, 3, 0, 0, 5],
    [0, 5, 0, 0, 9, 0, 6, 0, 0 ],
    [1, 3, 0, 0, 0, 0, 2, 5, 0],
    [0, 0, 0, 0, 0, 0, 0, 7, 4 ],
    [0, 0, 5, 2, 0, 6, 3, 0, 0]
    ];

var print = function(board){
    board.forEach(element => {
        process.stdout.write(element.toString());
        console.log();
    });

}
print(board);
console.log();

var isSafe = function(board,row,col,num){
    for(var i = 0;i<board[0].length;i++){
        //console.log(row,i);
        if(board[row][i] == num){
            return false;
        }
    }
    
    for(var j = 0;j<board[0].length;j++){
        if(board[j][col] == num){
            return false;
        }
    }
    var sqrtnum = Math.sqrt(board[0].length);
    var rowstart = row - row % sqrtnum;
    var colstart = col - col % sqrtnum;
    
    for(var k=rowstart;k<rowstart + sqrtnum ;k++){
        for(var m=colstart;m<colstart + sqrtnum ;m++){
            if(board[k][m] == num){
                return false;
            }
        }   
    }

    return true;
}
//console.log(isSafe(board,0,1,7));

var solveSudoku = function(board,n){
    var row = -1;
    var col = -1;
    var isEmpty = true;
    for(var i=0;i<n;i++){
        for(var j=0;j<n;j++){
            if(board[i][j] == 0){
                isEmpty = false;
                break;
            }
        }
        if(!isEmpty){
            break;
        }
    }
    if(isEmpty){
        return true;
    }
    row = i;
    col = j;

    for(var x =1;x<=n;x++){
        if(isSafe(board,row,col,x)){
            board[row][col] = x;
            console.log(board[row][col]);
            if(solveSudoku(board,n)){
                return true;
            }else{
                board[row][col] = 0;
            }
        }   
    }

    return false;
}
//console.log(board[0][0]);
console.log(solveSudoku(board,board[0].length));
if(solveSudoku(board,board[0].length)){
    
    print(board);
}
else{
    console.log("No Solution");
}