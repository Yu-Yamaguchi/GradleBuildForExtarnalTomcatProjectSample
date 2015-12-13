Gradleを使って外部プロジェクトのビルド・テストを実行するサンプル
====

##Overview
様々な大人の事情により、JavaによるWebアプリケーション開発を、Eclipseの**「Tomcatプロジェクト」**で開発しなければならないとしましょう。
Gradleプロジェクトにはしちゃいけないんです。

そこで、もう1つGradleのプロジェクトを作成し、大人の事情で作ったTomcatプロジェクトを外部参照して、Gradleからテストを実行したり、Findbugsを動かしたりできないかなぁと考えてみました。

そのサンプルです。

> **おそらく**

> - TomcatProject内部にテストコードを書かずに、TomcatProjectGradle側にテストコードを記述することができたかもしれない。（今回のケースでは、テストコードをTomcatProject内に作成することが制約上OKだったので上記構成となっている。）

## Usage

- コマンドプロンプトからカレントディレクトリをTomcatProjectGradleに変更。
- 以下のコマンドを実行
 - `gradlew testAllTests`
 
 これだけです。
 TomcatProjectにはbuildディレクトリなど生成されず、TomcatProjectGradle内にbuildディレクトリが生成され、JUnitやFindbugsのレポートが出力されていると思います。


## Author
[Yu-Yamaguchi](https://github.com/Yu-Yamaguchi)