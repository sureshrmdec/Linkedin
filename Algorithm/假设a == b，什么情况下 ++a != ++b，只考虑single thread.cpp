/*

*/

case 1: b refers to a
int main() {



    int a = 10;
    int &b = a;
    if (a == b) cout << "a == b" << endl;
    else cout << "a != b" << endl;
    if (++a == ++b) cout << "++a == ++b" << endl;
    else cout << "++a != ++b" << endl;


    return 0;
}


case 2: a is int, b is long and a overflows.

int main() {
    int a = 2147483647;
    long b = 2147483647;
    if (a == b) cout << "a == b" << endl;
    else cout << "a != b" << endl;
    if (++a == ++b) cout << "++a == ++b" << endl;
    else cout << "++a != ++b" << endl;
    return 0;
}
        
class CustomizedSelfIncrement {
public:
    static int selfIncrementSteps;
    int data;

    CustomizedSelfIncrement(int d) : data(d) {}

    bool operator==(CustomizedSelfIncrement& other) {
        return data == other.data;
    }

    CustomizedSelfIncrement& operator++() {
        data += selfIncrementSteps;
        ++selfIncrementSteps;
        return *this;
    }
};

int CustomizedSelfIncrement::selfIncrementSteps = 1;

int main() {
    CustomizedSelfIncrement a(10), b(10);
    if (a == b) cout << "a == b" << endl;
    else cout << "a != b" << endl;
    if (++a == ++b) cout << "++a == ++b" << endl;
    else cout << "++a != ++b" << endl;
    cout << "a.data = " << a.data << endl << "b.data = " << b.data << endl;


    return 0;
}
