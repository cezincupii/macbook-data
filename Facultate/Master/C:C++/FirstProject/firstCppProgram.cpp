#include<stdio.h>
#include<string.h>
#include <stdarg.h>

union s {
    int x;
    int y;
};

void swap(union s t) {
    int tmp=t.x;
    t.x=t.y;
    t.y=tmp;
}

int main()
{
  for(int i=0;i<10;i++) {
      if(!i%3) {
          printf("examen\n");
          continue;
      }
      else {
          printf("examen\n");
          break;
          printf("examen\n");
      }
      printf("examen \n");
  }
    return 0;
}