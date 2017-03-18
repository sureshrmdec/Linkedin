Write Through和Write Back
   Write Through和Write Back是阵列卡Cache的两种使用方式，也称为透写和回写。
   当选用write through方式时，系统的写磁盘操作并不利用阵列卡的Cache，而是直接与磁盘进行数据的交互。
   而write Back方式则利用阵列Cache作为系统与磁盘间的二传手，系统先将数据交给Cache，然后再由Cache将数据传给磁盘。
