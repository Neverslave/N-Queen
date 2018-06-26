package QueenProblem;

//N皇后问题
public class Queen {
    private   int row [] ; //行
    private int leftline[];//左斜线 同一列i-j+n相等
    private int  rightline[];//右斜线i+j相等
    private  int result[] ;
    private  int count = 0;//解答计数
    int n  ; //皇后的个数
    Queen(int n){
        //n 为皇后数量
        //初始化
        //为0代表未被占用，为1代表被占用
        row = new  int[n];
        leftline= new int[2*n];
        rightline= new int[2*n];
        result = new int [n];
        this.n = n;
        for (int i = 0; i <n ; i++) {
            row[i]=0;

        }
        for (int i = 0; i <n*2 ; i++) {
            leftline[i]=0;
            rightline[i]=0;

        }



    }
    void setPosition(int i){
        if(i>n-1){
            showResult();

        }else{
            for (int j = 0; j <n ; j++) {
                if(row[j]==0&&leftline[i-j+n]==0&&rightline[i+j]==0){
                   //设置放置位置
                    result[i]=j;
                    row[j]=1;
                    leftline[i-j+n]=1;
                    rightline[i+j]=1;

                    setPosition(i+1);
                    //
                    row[j]=0;
                    leftline[i-j+n]=0;
                    rightline[i+j]=0;

                }



            }




        }


    }
    private void  showResult(){
        count++;
        System.out.println("解答 "+count);
        for (int j = 0; j < n; j++) {
            for (int i= 0; i < n; i++) {
                if(result[j]==i){
                    System.out.print(" Q ");
                }else{
                    System.out.print(" . ");
                }

            }
            System.out.println();

        }


    }
    public static void main(String[] args){
        Queen queen = new Queen(13);
        queen.setPosition(0);
    }

}
