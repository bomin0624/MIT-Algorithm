# Hash table

###### tags: `Algorithm` `Hash`

Chaining
---
- 根據 load factor( α = n/m )改變Table大小
- 改變之後把node從舊的Table搬到新的Table的Rehashing( )：

TableDoubling( )：當α=n/m >1 時，表示資料量大於slot數量，就把Table大小m加倍(並配置m加倍後的Table)，如此在理論上可以儘量避免Collision發生，增加搜尋資料的效率。

#### 為什麼選擇Table大小加倍(size*=2)，而不是加一(size++)、加二？

m' = m+1 : cost of n inserts = Θ(1+2+3+4+...n) = Θ(n^2)

m' = 2m : cost of n inserts = Θ(1+2+4+8+16+...+n) =Θ(n)


TableShrinking( )：當α= n/m < 1/4 時，表示資料量減少到Table大小m的 1/4，就把Table大小m減半(並配置m減半後的Table)，以節省記憶體空間。

#### 為什麼選擇 α = n/m < 1/4 而不是 α=n/m < 1/2？

為了避免資料量在「臨界點」增增減減，造成不斷地動態配置記憶體(成本相當高)。

Example
---
起初n=8,m=8，現增加一筆資料，變成n=9,m=8，觸發TableDoubling()，變成n=9,m=16。

若接下來連續刪除兩筆資料，變成n=7,m=16，因為 n/m < 1/2，將會觸發一次TableShrinking()，變成n=7,m=8。

若接下來又連續增加兩筆資料，又將觸發一次TableDoubling()...依此類推，為了避免這種不斷配置記憶體的情況發生，寧可犧牲一點記憶體空間，等到n/m < 1/4 再觸發TableShrinking( )，重新為Table配置新的記憶體位置。

Rehashing( )：當TableDoubling()/TableShrinking()增加/減半Table大小 m 後，需要把舊的Table上的資料(node)搬到新的Table上，過程將會透過Hash Function根據各筆資料的key重新分配一次index(因此稱為Rehashing)，此index即為資料在新的Table上的位置



![](https://i.imgur.com/MJ59Pdz.png =x300)
[Hash Table：Chaining](http://alrightchiu.github.io/SecondRound/hash-tablechaining.html)



Open Addressing
---
Open Addressing則是將每筆資料都放在書桌(Table)本身配備的抽屜(slot)，一格抽屜只能放一個物品，如果抽屜都滿了，就得換張書桌(重新配置記憶體給新的Table)

#### load factor( α=n/m ) <= 1



Probing 
---

Hash function specifies order of slots to probe for a key (for insert / search / delete)

#### h : U × {0,1,..., m−1} → {0,1,... m−1}

- U is universe of keys
- Probing的次數最多不會超過Table大小m，定義從第0次到第m−1次。
- 隨著「次數增加」，Hash Function的值域可以視為{0,1,...,m−1}的 permutation

#### { h(k,0),h(k,1)..., h(k,m−1)} = permutation of {0,1,...,m−1}

Insert(k,v)
---

Keep probing until an empty slot is found,Insert item when found

Search(k)
---
As long as the slots encountered are occupied by keys != k, keep probing until you either <font color="#357EC7">encounter k</font> or find an <font color="#357EC7">empty slot</font>.

Delete
---
Replace deleted item with <font color="#357EC7">DeleteMe</font> flag ( different from None )

Insert treats <font color="#357EC7">DeleteMe</font> the same as None

Search keeps going ( treats different from None )

特別注意，Probing的Hash Function與Chaining的Hash Function略有不同(雖然都稱為Hash Function)：

- Chaining使用的Hash Function只有一個參數，就是資料的Key
- Open Addressing使用的Hash Function有兩個參數，一個是資料的Key，另一個是Probing的「次數」


Linear probing
---

#### Definition: h(k,i) = ( h′(k) + i ) mod m

- h′(k) is ordinary hash function
- i 是 probing 次數

![](https://i.imgur.com/BNrhV3L.png =x300)

Disadvantage
---
#### Cluster consecutive groups of occupied slots which keep longer

![](https://i.imgur.com/An0p1sL.png =x300)




Double hashing
---
#### 加入「第二個Hash Function」來影響「次數i」

#### Definition: h(k,i) = ( h1(k) + i * h2(k)) mod m

if h2（k）is relatively prime to m (h2(k)一定要與m互質) => permutation

m = 2^r , h2(k) for all k is odd

Advantage
---
因為同時有兩個Hash Function h1(k),h2(k) ，若兩者個值域都是{0,1,...,m−1}，那麼Double Hashing一共可以產生m2種不同的Probing Sequence，因此可以大大減緩clustering。


Efficiency：Think about load factor α
---
#### 不適合使用Open Addressing

以Open Addressing之Unsuccessful Search為例，O( 1/（1−α）)，根據其時間複雜度可以觀察出，當load factor趨近於1時(Table快被放滿)，那麼時間複雜度會趨近無限大：limα→1 O(1/(1−α)) → O(∞)

不過Open Addressing使用Array存放資料，不需要頻繁使用動態記憶體配置，所以如果load factor沒有超過0.5(有些使用0.7)，那麼Open Addressing會是不錯的選擇。

#### Memory的使用

Chaining使用Linked list，每個node裡面會帶一個pointer記錄下一個node的記憶體位置，因此會比純粹使用Array存放資料的Open Addressing多花一點記憶體空間。

不過前面提到，Open Addressing考慮load factor儘量不要超過0.5，因此將有近一半的記憶體位置閒置。


#### <font color="#357EC7">兩種處理Collision的方法沒有絕對的好壞，要視情況而定</font>

Hashmap vs Hashtable
---

1. HashMap is non-synchronized. It is not-thread safe and can’t be shared between many threads without proper synchronization code 
2. Hashtable is synchronized. It is thread-safe and can be shared with many threads.
3. HashMap allows one null key and multiple null values 
4.  Hashtable doesn’t allow any null key or value.
5. HashMap is generally preferred over HashTable if thread synchronization isn't needed

Why HashTable doesn’t allow null and HashMap does?
---
To successfully store and retrieve objects from a HashTable, the objects used as keys must implement the hashCode method and the equals method. Since null is not an object, it can’t implement these methods. 
HashMap is an advanced version and improvement on the Hashtable. HashMap was created later.
