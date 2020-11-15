# weekend2


# S.O.L.I.D
## Pengenalan

SOLID adalah sebuah singkatan dari 5 hal penting ketika hendak menerapkan OOP(Object Oriented Programming). Lima prinsip ini dikenalkan oleh Robert C. Martin (Paman Bob) dalam 2000 lembar karyanya yang berjudul Design Principle and Design Patterns.
- ### **S- Single responsibility Principle**

Maksud utama dalam prinsip ini adalah bahwa setiap class dan fungsi dalam sebuah program harus memiliki satu fungsi utama atau tanggung jawab. Jadi apabila ada sebuah perubahan dalam program makan hanya satu module, class atau method yang diubah.
- ### **O- Open/Close Principle**

Berarti sebuah entitas(class module function dll) terbuka untuk dikembangkan/diturunkan namun tertutup untuk dirubah, dalam artian entitas tersebut aman dari sengaja/ketidak sengajaan dirubah dari entitas lain.
L- Liskov Subtitution Principle

Paman Bob pernyataan sebagai berikut “if for each object o1 of type S there is an object o2 of type T such that for all programs P defined in terms of T, the behavior of P is unchanged when o1 is substituted for o2 then S is a subtype of T”. Sederhanannya, Liskov’s substitution adalah aturan yang berlaku untuk hirarki pewarisan. Proses mendesain kelas-kelas dengan tujuan agar ketergantungan antar klien dapat disubstitusikan tanpa klien mengetahui tentang perubahan yang ada. SubClass wajib untuk menerapkan fungsi dan properti dari SuperClass,dan perilaku yang sama dengan SuperClass-nya.
- ### **I- Interface Segretation Principle**

Bertujuan untuk mengurangi ketergantungan kelas kepada interface kelas yang dibutuhkan. Ketergantungan ini bisa terjadi apabila kelas terpaksa mengimplementasikan fungsi-fungsi yang tidak dibutuhkan dari interface. Menurut prinsip ini, kelas interface disarankan untuk membiliki fungsi yang lebih sedikit sesuai tujuan/fungsi utama nya.
- ### **D- Dependency Inversion Principle**
# Menu


Menu adalah komponen antarmuka pengguna yang banyak dijumpai di berbagai jenis aplikasi, menu memberikan kemudahan kepada user dalam memilih tindakan di dalam aplikasi.

Ada beberapa macam menu yang bisa digunakan di dalam Android:

- Options menu dan app bar.
- Context menu dan contextual action mode.
- Popup menu


Untuk mendefinisikan menu, buatlah sebuah file XML dalam direktori res/menu/ proyek dan bangun menu dengan elemen-elemen berikut:



# Dialog

Dialog adalah tampilan kecil yang digunakan untuk meminta user untuk memilih tindakan atau memasukkan informasi tambahan. Dialog tidak mengisi secara penuh layar android dan secara normal digunakan user untuk melakukan tindakan sebelum memproses keinginan user.
- AlertDialog
- DatePickerDialog atau TimePickerDialog

# App Icon

Ikon dalam aplikasi menjadi salah hal kecil yang bisa jadi penting, karena ikon akan memberikan identitas dari aplikasi sebelum pengguna memutuskan untuk membuka aplikasi

App Icon pada Android mendukung untuk berbagai macam tema yang dimiliki oleh user, seperti icon circle, square, legacy dsb.


# RecyclerView

RecyclerView adalah sebuah scrollable view yang menampilkan data berupa iterable pada Android, RecyclerView merupakan versi yang lebih canggih dari ListView dimana RecyclerView akan melakukan binding pada data yang terlihat saja.

```kotlin
implementation 'androidx.recyclerview:recyclerview:1.1.0'
```

Pemanggilan RecyclerView di dalam XML Android:

```kotlin
<androidx.recyclerview.widget.RecyclerView xmlns:android="http://schemas.android.com/apk/res/android"
   xmlns:app="http://schemas.android.com/apk/res-auto"
   android:id="@+id/rvList"
   android:layout_width="match_parent"
   android:layout_height="match_parent"
   app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager" />
```
## RecyclerView Adapter

RecyclerView adapter digunakan untuk memasukkan data iterable ke dalam RecyclerView, mengganti data iterable yang baru, mengganti tampilan saat konten tidak terlihat dan hanya menampilkan data pada konten yang terlihat saja.

```kotlin
class NameAdapter : RecyclerView.Adapter<NameAdapter.ViewHolder>() {

   class ViewHolder(view: View) : RecyclerView.ViewHolder(view) { }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       TODO("Not yet implemented")
   }

   override fun onBindViewHolder(holder: ViewHolder, position: Int) { TODO("Not yet implemented") }

   override fun getItemCount(): Int { TODO("Not yet implemented") }
}
```

## RecyclerView ViewHolder
RecyclerView ViewHolder adalah sebuah class yang digunakan untuk melakukan proses binding data pada setiap item pada RecyclerView di android.

```kotlin
class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
   fun bindData(s: String) {
       val tvName = itemView.findViewById<TextView>(android.R.id.text1)
       tvName.text = s
   }
}
```

# Shared Prefereces

Shared Preferences adalah salah satu class yang memiliki fungsi menyimpan data baik dari pengguna maupun sistem secara permanen ke memori lokal pada handphone pengguna. Ia meyimpan data tersebut dalam bentup Map yang memiliki key dan value. Salah satu contoh penggunaan nya adalah untuk menyimpan API key untuk keperluan akses aplikasi.

SharedPreferences adalah penyimpanan lokal untuk small data collection yang mempunyai key dan value pada Android.

```kotlin
private const val SHARED_TODO = "id.refactory.todolistapp"
private lateinit var shared: SharedPreferences

fun getPref(context: Context): SharedPreferences {
   if (!this::shared.isInitialized){
    shared = context.getSharedPreferences(SHARED_TODO, Context.MODE_PRIVATE)
   return shared
   } 
}
```
# Activities
## #Intent

Intent digunakan untuk berpindah antar activity pada android, yang pada pengguna berarti berpindah antar layar/menu. Dalam perpindahan ini intent bisa membawa informasi/data dari aktivity sebelumnya.

Intent adalah object perpesanan yang digunakan untuk meminta tindakan dari komponen, intent juga memfasilitasi komunikasi antar komponen dalam berbagai cara:
- Starting an activity
- Starting a service
- Delivering a broadcast

Intent memfasilitasi dalam melakukan pemanggilan activity baru, pada startActivity meminta sebuah input parameter berupa intent. Intent dapat juga membawa data antar activity.

```kotlin
val intent = Intent(this, SecondActivity::class.java).putExtra(DATA, 100)
startActivity(intent)
```

## #Intent Filter

Intent filter merupakan ekspresi dari sebuah komponen di dalam file manifest pada aplikasi Android. Intent filter digunakan untuk menentukan jenis intent yang diterima oleh komponen.
```kotlin
<activity android:name=".MainActivity">
   <intent-filter> //intent filter 
       <action android:name="android.intent.action.MAIN" />
       <category android:name="android.intent.category.LAUNCHER" />
   </intent-filter>
</activity>
```
contoh : 
```kotlin
<activity android:name=".SecondActivity">
   <intent-filter>
       <action android:name="android.intent.action.SEND"/>
       <category android:name="android.intent.category.DEFAULT"/>
       <data android:mimeType="text/plain"/>
   </intent-filter>
   <intent-filter>
       <action android:name="android.intent.action.SEND"/>
       <action android:name="android.intent.action.SEND_MULTIPLE"/>
       <category android:name="android.intent.category.DEFAULT"/>
       <data android:mimeType="image/*"/>
       <data android:mimeType="video/*"/>
   </intent-filter>
</activity>
```
## #Parcels

Parcel adalah fungsi yang secara singkat mengatasi kelemahan yang dihasilkan dari metode perpindahan data oleh intent. Yang sebelumnya developer harus menuliskan satu satu data yang memiliki tipe primitive seperti String, Integer, Boolean dll, menjadi hanya satu data saja dalam bentuk object.

Parcelize Sebuah object bundle yang digunakan untuk memberikan data berupa object kepada komponen Android lainnya berdasarkan key.

```kotlin
@Parcelize
data class User(val name: String, val age: Int) : Parcelable
override fun onCreate(savedInstanceState: Bundle?) {
   super.onCreate(savedInstanceState)
   setContentView(R.layout.activity_main)
   btnNext.setOnClickListener {
       val user = User("Angga Saputra", 20)
       val intent = Intent(this, SecondActivity::class.java).apply { putExtra(DATA, user) }
       startActivity(intent)
   }
}
```


# Fragment
**Fragment** adalah sebuah reuseable class yang mengimplement beberapa fitur sebuah Activity. Fragment biasanya dibuat sebagai bagian dari suatu antarmuka. Sebuah fragment harus berada di dalam sebuah activity, mereka tidak dapat berjalan sendiri tanpa adanya activity tempat mereka menempel.

![fragment](https://developer.android.com/images/fundamentals/fragments.png)

### **Fragment Lifecycle**

Fragment memiliki banyak method yang dapat di override seperti halnya Activity :

- `onAttach()` dipanggil saat sebuah fragment terhubung ke activity.
- `onCreate()` diapnggil saat sebuah fragment dibuat (objeknya di memori).
- `onCreateView()` dipanggil saat fragment sudah siap membaca sebuah layout.
- `onViewCreated()` dipanggil setelah onCreateView() dan memastikan layout yang dibaca fragment adalah non-null. Semua pengaturan view seperti pembacaan findViewById, menambah onClickListener dapat dilakukan di sini.
- `onActivityCreated()` dipanggil setelah activity pembaca sudah menyelesaikan onCreate()-nya.
- `onStart()` dipanggil setelah fragment siap untuk ditampilkan di layar.
- `onResume()` - Dipakai untuk melakukan pembacaan data yang lebih "rumit" seperti lokasi, sensor, dll.
- `onPause()` - Tempat melepas data "rumit". Lakukan commit di sini.
- `onDestroyView()` dipanggil saat layout sebuah fragment akan dihapus dari memori, namun fragmentnya masih ada di memori.
- `onDestroy()` dipanggil jika fragment sudah tidak dipakai.
- `onDetach()` dipanggil saat fragment tidak lagi terhubung ke sebuah activity.

urutan eksekusi lifecycle dapat dilihat pada gambar di bawah:

![fragment-lifecycle](https://developer.android.com/images/fragment_lifecycle.png)

### **Membuat Sebuah Fragment**

Sebuah fragment, seperti activity, memiliki XML layout-nya sendiri dan sebuah kelas java sebagai controller dari Fragment tersebut.

Layout XML yang dimiliki oleh fragment, sama seperti layout-layout lainnya dan bisa memiliki nama apa saja (selama memiliki format yang ditentukan). Anggap kita memiliki layout sebagai berikut:

- **fragment_foo.xml**
```kotlin
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" >

    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TextView" />

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button" />

</LinearLayout>
```

Dengan sebuah kelas kotlin sebagai controller:

- **foo.kt**

```kotlin
import androidx.fragment.app.Fragment


class foo : Fragment() {

    // Method onCreateView dipanggil saat Fragment harus menampilkan layoutnya      
    // dengan membuat layout tersebut secara manual lewat objek View atau dengan     
    // membaca file XML

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        view.setOnClickListener { Toast.makeText(activity, "Clicked", Toast.LENGTH_SHORT).show() }
        return view
    }

    // Method ini dipanggil sesaat setelah onCreateView().
    // Semua pembacaan view dan penambahan listener dilakukan disini 
    // (atau bisa juga didalam onCreateView)
  
     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
```
FrameLayout adalah view berupa container yang akan menampung fragment pada Activity sedang berjalan.
```kotlin
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
   xmlns:app="http://schemas.android.com/apk/res-auto"
   xmlns:tools="http://schemas.android.com/tools"
   android:id="@+id/flMain"
   android:layout_width="match_parent"
   android:layout_height="match_parent"
   tools:context=".MainActivity"/>
```

### **Fragment Transaction**
FragmentManager class dan FragmentTransaction class digunakan untuk menambahkan, menghapus dan mengganti fragment di FrameLayout di dalam Activity pada saat runtime.

```kotlin
supportFragmentManager.beginTransaction().add(R.id.flMain, BlankFragment()).commit()
supportFragmentManager.beginTransaction().replace(R.id.flMain, BlankFragment()).commit()
supportFragmentManager.beginTransaction().remove(BlankFragment())
```

